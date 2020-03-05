package com.xvnan.service;

import com.baomidou.mybatisplus.service.IService;
import com.xvnan.model.Keyword;

import java.util.List;

public interface KeywordService extends IService<Keyword> {
    Keyword stringToArray(Keyword keyword);

    Keyword arrayToString(Keyword keyword);

    List getKeywords();

    Integer insertKeyword(String s1,String s2);

    Integer deleteKeyword(String s1);

    String deleteMarks(String s1);
}
