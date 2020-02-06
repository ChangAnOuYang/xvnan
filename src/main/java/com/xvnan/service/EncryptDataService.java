package com.xvnan.service;

import com.baomidou.mybatisplus.service.IService;
import com.xvnan.model.EncryptData;
import com.xvnan.model.FeedbackData;
import com.xvnan.model.Index;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


public interface EncryptDataService extends IService<EncryptData> {

    public EncryptData toMysql(EncryptData data);

    public EncryptData fromMysql(EncryptData data);

    public List getEncryptDatas();
}
