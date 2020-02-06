package com.xvnan.model;


import java.io.Serializable;
import java.util.Arrays;

/**
 * @author nan_xu
 * @date 2020/1/6
 */
public class EncryptData implements Serializable {
    private static final long serialVersionUID = 1L;

    private Index[] index;
    private FeedbackData feedbackData;
    private String indexString;
    private String feedbackDataString;

    public EncryptData(String indexString,String feedbackDataString){
        this.indexString=indexString;
        this.feedbackDataString=feedbackDataString;
    }
    
    public EncryptData(Index[] index,FeedbackData feedbackData){
        this.index=index;
        this.feedbackData=feedbackData;
    }

    public EncryptData(){

    }
    
    public String getIndexString() {
        return indexString;
    }

    public void setIndexString(String indexString) {
        this.indexString = indexString;
    }

    public String getFeedbackDataString() {
        return feedbackDataString;
    }

    public void setFeedbackDataString(String feedbackDataString) {
        this.feedbackDataString = feedbackDataString;
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
