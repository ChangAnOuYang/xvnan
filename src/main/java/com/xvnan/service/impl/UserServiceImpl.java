package com.xvnan.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xvnan.mapper.UserMapper;
import com.xvnan.model.User;
import com.xvnan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String userName,String password) {
        String privateKey=userMapper.login(userName,password);
        return privateKey;
    }
}
