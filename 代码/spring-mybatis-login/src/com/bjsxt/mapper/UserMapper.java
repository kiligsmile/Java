package com.bjsxt.mapper;

import com.bjsxt.pojo.User;

public interface UserMapper {

    //查询单个操作
    public User   selectOne(String  uname,String  pwd);

    //添加操作
    public   int   insert(User user);

}
