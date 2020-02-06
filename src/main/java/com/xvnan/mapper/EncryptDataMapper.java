package com.xvnan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xvnan.model.EncryptData;

import java.util.List;

public interface EncryptDataMapper extends BaseMapper<EncryptData> {
    public List getEncryptDatas();
}
