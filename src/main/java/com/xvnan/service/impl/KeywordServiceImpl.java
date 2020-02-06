package com.xvnan.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xvnan.mapper.KeywordMapper;
import com.xvnan.model.Keyword;
import com.xvnan.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl extends ServiceImpl<KeywordMapper, Keyword> implements KeywordService {

    @Autowired
    private KeywordMapper keywordMapper;

    @Override
    public Keyword stringToArray(Keyword keyword) {

        String[] strings=keyword.getKeyIndexString().split(";");
        int[] ints=new int[strings.length];
        for (int index=0;index<strings.length;index++){
            ints[index]=new Integer(strings[index]);
        }
        keyword.setKeyIndex(ints);
        keyword.setKeyIndexString("");
        return keyword;
    }

    @Override
    public Keyword arrayToString(Keyword keyword) {
        String string="";
        for(int i:keyword.getKeyIndex()){
            string=string+i+";";
        }
        keyword.setKeyIndexString(string);
        return keyword;
    }

    @Override
    public List getKeywords() {
        return keywordMapper.getKeywords();
    }

    @Override
    public Integer insertKeyword(String s1, String s2) {
        return keywordMapper.insertKeyword(s1,s2);
    }

    @Override
    public Integer deleteKeyword(String s1) {
        return keywordMapper.deleteKeyword(s1);
    }

    @Override
    public String deleteMarks(String s1) {
        if(s1.length()<2)return s1;
        if(s1.charAt(s1.length()-1)==34){
            s1=s1.substring(0,s1.length()-1);
        }
        if(s1.charAt(0)==34){
            s1=s1.substring(1,s1.length());
        }
        return s1;
    }


}
