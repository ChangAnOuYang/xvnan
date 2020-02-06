package com.xvnan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xvnan.model.Keyword;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeywordMapper extends BaseMapper<Keyword> {
    public List getKeywords();

    public Integer deleteKeyword(@Param("name") String name);

    public Integer insertKeyword(@Param("name") String name,@Param("key_index_string") String key_index_string);
}
