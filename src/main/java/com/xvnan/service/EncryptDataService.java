package com.xvnan.service;

import com.baomidou.mybatisplus.service.IService;
import com.xvnan.model.EncryptData;
import com.xvnan.model.FeedbackData;
import com.xvnan.model.Index;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


public interface EncryptDataService extends IService<EncryptData> {

    EncryptData toMysql(EncryptData data);

    EncryptData fromMysql(EncryptData data);

    List getEncryptDatas();

    Integer insertEncryptData(EncryptData encryptData);
}
