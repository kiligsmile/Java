package com.bjsxt.service;

import com.bjsxt.pojo.User;

import java.util.List;

public interface UserService {

    //添加用户
    public    int   save(User  user);

    //查询所有用户
    public List<User>  findAll();
}
