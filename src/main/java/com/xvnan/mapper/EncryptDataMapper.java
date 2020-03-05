package com.xvnan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xvnan.model.EncryptData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EncryptDataMapper extends BaseMapper<EncryptData> {
    List<EncryptData> getEncryptDatas();

    Integer insertEncryptData(@Param("index_string") String index_string, @Param("data_string") String data_string);
}
