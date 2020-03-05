package com.xvnan.model;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author nan_xu
 * @date 2020/1/6
 */
public class EncryptData implements Serializable {

    private Index[] index;
    private FeedbackData feedbackData;
    private String indexString;
    private String dataString;


    private String indexArray;
    private String cipherMessage;
    private String time;

    public EncryptData(String indexString,String dataString){
        this.indexString=indexString;
        this.dataString=dataString;
    }

    public EncryptData(String indexArray,String cipherMessage,String time){
        JSONArray jsonArray=JSONArray.parseArray(indexArray);
        Index[] indices=new Index[jsonArray.size()];
        for (int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            indices[i]=JSONObject.toJavaObject(jsonObject,Index.class);
        }
        FeedbackData feedbackData=new FeedbackData();
        feedbackData.cipherMessage=cipherMessage;
        feedbackData.time=new Long(time);
        this.index=indices;
        this.feedbackData=feedbackData;
    }

    public EncryptData(Index[] index,FeedbackData feedbackData){
        this.index=index;
        this.feedbackData=feedbackData;
    }

    public EncryptData(){

    }


    public String getIndexArray() {
        return indexArray;
    }

    public void setIndexArray(String indexArray) {
        this.indexArray = indexArray;
    }

    public String getCipherMessage() {
        return cipherMessage;
    }

    public void setCipherMessage(String cipherMessage) {
        this.cipherMessage = cipherMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIndexString() {
        return indexString;
    }

    public void setIndexString(String indexString) {
        this.indexString = indexString;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public Index[] getIndex() {
        return index;
    }

    public void setIndex(Index[] index) {
        this.index = index;
    }

    public FeedbackData getFeedbackData() {
        return feedbackData;
    }

    public void setFeedbackData(FeedbackData feedbackData) {
        this.feedbackData = feedbackData;
    }

    
    
    @Override
    public String toString() {
        return "EncryptData{" +
                "index=" + Arrays.toString(index) +
                ", feedbackData=" + feedbackData +
                '}';
    }
}
