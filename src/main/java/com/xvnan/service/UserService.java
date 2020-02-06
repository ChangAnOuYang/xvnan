package com.xvnan.service;

import com.baomidou.mybatisplus.service.IService;
import com.xvnan.model.User;

public interface UserService extends IService<User> {

    String login(String userName,String password);
}
