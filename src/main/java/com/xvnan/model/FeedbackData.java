package com.xvnan.model;

public class FeedbackData {
    public String cipherMessage;
    public long time;

    @Override
    public String toString() {
        return "FeedbackData{" +
                "cipherMessage='" + cipherMessage + '\'' +
                ", time=" + time +
                '}';
    }
}
