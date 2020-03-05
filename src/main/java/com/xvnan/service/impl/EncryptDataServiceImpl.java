package com.xvnan.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xvnan.mapper.EncryptDataMapper;
import com.xvnan.model.EncryptData;
import com.xvnan.model.FeedbackData;
import com.xvnan.model.Index;
import com.xvnan.service.EncryptDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncryptDataServiceImpl extends ServiceImpl<EncryptDataMapper, EncryptData> implements EncryptDataService {
    //@Value("${normal_split_string}")
    private String normalString="##";

    //@Value("${index_split_string}")
    private String indexSplitString="%%";

    @Autowired
    private EncryptDataMapper encryptDataMapper;

    @Override
    public EncryptData toMysql(EncryptData data){
        String indexString="";
        String feedbackDataString="";
        FeedbackData feedbackData=data.getFeedbackData();
        Index[] indexs=data.getIndex();
        feedbackDataString=feedbackData.cipherMessage+normalString+feedbackData.time;
        for (Index in:indexs){
            indexString=indexString+in.C0+indexSplitString+in.C1+indexSplitString+in.C2+indexSplitString+in.Mv+normalString;
        }
        data.setDataString(feedbackDataString);
        data.setIndexString(indexString);
        return data;
    }

    @Override
    public EncryptData fromMysql(EncryptData data){
        //System.out.println(data.toString());
        FeedbackData feedbackData=new FeedbackData();
        String[] feedbackStrings=data.getDataString().split(normalString);
        feedbackData.cipherMessage=feedbackStrings[0];
        feedbackData.time=new Long(feedbackStrings[1]);
        data.setFeedbackData(feedbackData);
        String[] indexStrings=data.getIndexString().split(normalString);
        Index[] indexs=new Index[indexStrings.length];
        for (int i=0;i<indexs.length;i++){
            Index index=new Index();
            String[] cx=indexStrings[i].split(indexSplitString);
            index.C0=cx[0];
            index.C1=cx[1];
            index.C2=cx[2];
            index.Mv=cx[3];
            indexs[i]=index;
        }
        data.setIndex(indexs);
        return data;
    }

    @Override
    public List getEncryptDatas() {
        return encryptDataMapper.getEncryptDatas();
    }

    @Override
    public Integer insertEncryptData(EncryptData encryptData) {
        return encryptDataMapper.insertEncryptData(encryptData.getIndexString(),encryptData.getDataString());
    }


}
