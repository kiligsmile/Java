package com.bjsxt.mapper;

import com.bjsxt.pojo.User;

import java.util.List;

public interface UserMapper {

    //添加操作
    public   int   insert(User  user);

    //查询操作
    public List<User>  selectAll();
}
