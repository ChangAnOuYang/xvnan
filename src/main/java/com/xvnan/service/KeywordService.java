package com.xvnan.service;

import com.baomidou.mybatisplus.service.IService;
import com.xvnan.model.Keyword;

import java.util.List;

public interface KeywordService extends IService<Keyword> {
    public Keyword stringToArray(Keyword keyword);

    public Keyword arrayToString(Keyword keyword);

    public List getKeywords();

    public Integer insertKeyword(String s1,String s2);

    public Integer deleteKeyword(String s1);

    public String deleteMarks(String s1);
}
