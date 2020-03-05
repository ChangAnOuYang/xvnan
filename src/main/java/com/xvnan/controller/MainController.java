package com.xvnan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xvnan.model.*;
import com.xvnan.service.EncryptDataService;
import com.xvnan.service.KeywordService;
import com.xvnan.util.JPBCUtil;
import com.xvnan.jpbc.api.PairingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/main")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Value("${file_local}")
    private String file_local="/data/file_local";

    @Autowired
    private EncryptDataService encryptDataService;


    @Autowired
    private KeywordService keywordService;

    @GetMapping("/getKey")
    @ResponseBody
    public String getKey() {
        try{
            ObjectInputStream objectInputStream1=new ObjectInputStream(new FileInputStream(new File(file_local+"/MSK")) );
            ObjectInputStream objectInputStream2=new ObjectInputStream(new FileInputStream(new File(file_local+"/Params")) );
            ObjectInputStream objectInputStream3=new ObjectInputStream(new FileInputStream(new File(file_local+"/Pairing")) );
            MSK msk= (MSK) objectInputStream1.readObject();
            Params params=(Params)objectInputStream2.readObject();
            PairingParameters pairingParameters= (PairingParameters) objectInputStream3.readObject();
            //HashMap<String,String> result=new HashMap<>();
            JSONObject result=new JSONObject();
            result.put("MSK",msk);
            result.put("Params",params);
            result.put("PairingParameters",pairingParameters);
            return result.toJSONString();
        }catch (Exception ex){
            logger.error("序列化错误",ex);
        }
        return "服务器异常";
    }

    @PostMapping("/uploadData")
    @ResponseBody
    public String uploadData(@RequestBody EncryptData encryptData){
        encryptData=new EncryptData(encryptData.getIndexArray(),encryptData.getCipherMessage(),encryptData.getTime());
        //System.out.println(encryptData.toString());
        JSONObject jsonObject=new JSONObject();
        try{
            encryptData=encryptDataService.toMysql(encryptData);
            encryptDataService.insertEncryptData(encryptData);
            jsonObject.put("code",0);
            jsonObject.put("msg","success");
            return jsonObject.toJSONString();
        }catch (Exception ex){
            logger.error("数据异常",ex);
            jsonObject.put("code",-1);
            jsonObject.put("msg","error");
            jsonObject.put("data",ex);
            return jsonObject.toJSONString();
        }
    }

    @GetMapping("/getKeywords")
    @ResponseBody
    public String getKeywords(){
        JSONObject jsonObject=new JSONObject();
        try{
            List<Keyword> list=keywordService.getKeywords();
            JSONArray jsonArray=new JSONArray();
            for (Keyword keyword:list){
                keyword.setKeyIndex(Keyword.stringToArray(keyword.getKeyIndexString()));
                jsonArray.add(keyword);
            }
            jsonObject.put("code",0);
            jsonObject.put("msg","success");
            jsonObject.put("data",jsonArray);
            return jsonObject.toJSONString();
        }catch (Exception ex){
            logger.error("获取关键字失败",ex);

            jsonObject.put("code",-1);
            jsonObject.put("msg","error");
            jsonObject.put("data",ex);
            return jsonObject.toJSONString();
        }
    }

    @PostMapping("/deleteKeyword")
    @ResponseBody
    public String deleteKeyword(@RequestBody String name){
        name=keywordService.deleteMarks(name);
        JSONObject jsonObject=new JSONObject();
        try{
            keywordService.deleteKeyword(name);
            jsonObject.put("code",0);
            jsonObject.put("msg","删除成功");
        }catch (Exception ex){
            logger.error("删除异常",ex);
            jsonObject.put("code",-1);
            jsonObject.put("msg","删除异常");
        }
        return jsonObject.toJSONString();
    }

    @PostMapping("/insertKeyword")
    @ResponseBody
    public String insertKeyword(@RequestBody String name){
        name=keywordService.deleteMarks(name);
        JSONObject jsonObject=new JSONObject();
        try{
            Random random=new Random();
            int[] index=new int[5];
            for (int i=0;i<5;i++){
                index[i]=random.nextInt(10);
            }
            keywordService.insertKeyword(name,Keyword.arrayTOString(index));
            jsonObject.put("code",0);
            jsonObject.put("msg","添加成功");

        }catch (Exception ex){
            logger.error("添加异常",ex);
            jsonObject.put("code",-1);
            jsonObject.put("msg","添加失败");
        }
        return jsonObject.toJSONString();
    }

    @PostMapping("searchData")
    @ResponseBody
    public String searchData(@RequestBody EncryptData encryptData){
        try{
            String[] strs=new String[2];
            strs[0]=encryptData.getIndexString();
            strs[1]=encryptData.getIndexArray();
            List<EncryptData> list=encryptDataService.getEncryptDatas();

            EncryptData[] list2=new EncryptData[list.size()];
            for (int i=0;i<list.size();i++){
                list2[i]=encryptDataService.fromMysql(list.get(i));
            }
            List<FeedbackData> result=JPBCUtil.search(list2,strs);
            JSONArray jsonArray=new JSONArray();
            for (FeedbackData feedbackData:result){
                jsonArray.add(feedbackData);
            }
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("code",0);
            jsonObject.put("msg","success");
            jsonObject.put("data",jsonArray);
            return jsonObject.toJSONString();
        }catch (Exception ex){
            logger.error("查询异常",ex);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("code",-1);
            jsonObject.put("msg","error");
            jsonObject.put("data",ex);
            return jsonObject.toJSONString();
        }

    }
}
