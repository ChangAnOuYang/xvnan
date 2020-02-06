package com.xvnan.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xvnan.model.User;
import com.xvnan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserLoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        String result="";
        //System.out.println("成功------------------------------------------");
        try{
            if(StringUtils.isEmpty(user.getUserName())){
                jsonObject.put("code",1);
                jsonObject.put("msg","空的用户名");
                return jsonObject.toJSONString();
            }

            String key=userService.login(user.getUserName(),user.getPassword());
            if(StringUtils.isEmpty(key)){
                result= "用户名或密码错误";
                jsonObject.put("code",1);
            }else {
                jsonObject.put("code",0);
                result="登录成功";
                jsonObject.put("data", key);

            }
        }catch (Exception e){
            logger.error("登录异常",e);
            result="未知异常";
            jsonObject.put("code",-1);
        }
        jsonObject.put("msg",result);
        return jsonObject.toJSONString();
    }
}
