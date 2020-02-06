package com.xvnan.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xvnan.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    String login(@Param("userName") String userName,@Param("password") String password);
}
