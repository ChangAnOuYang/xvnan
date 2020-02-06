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
    private String normalString="&*#";

    //@Value("${index_split_string}")
    private String indexString="&#%";

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
            indexString=in.C0+indexString+in.C1+indexString+in.C2+indexString+in.Mv+normalString;
        }
        data.setFeedbackDataString(feedbackDataString);
        data.setIndexString(indexString);
        return data;
    }

    @Override
    public EncryptData fromMysql(EncryptData data){
        FeedbackData feedbackData=new FeedbackData();
        String[] feedbackStrings=data.getIndexString().split(normalString);
        feedbackData.cipherMessage=feedbackStrings[0];
        feedbackData.time=new Long(feedbackStrings[1]);
        data.setFeedbackData(feedbackData);
        String[] indexStrings=data.getIndexString().split(normalString);
        Index[] indexs=new Index[indexStrings.length];
        for (int i=0;i<indexs.length;i++){
            Index index=new Index();
            String[] cx=indexStrings[i].split(indexString);
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
}
