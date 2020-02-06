package com.xvnan.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer intitution_id;

    private String userName;

    private String password;

    private String privateKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIntitution_id() {
        return intitution_id;
    }

    public void setIntitution_id(Integer intitution_id) {
        this.intitution_id = intitution_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", intitution_id=" + intitution_id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", privateKey='" + privateKey + '\'' +
                '}';
    }
}
