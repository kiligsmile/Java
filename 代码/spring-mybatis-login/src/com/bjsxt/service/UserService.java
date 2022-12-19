package com.bjsxt.service;

import com.bjsxt.pojo.User;

public interface UserService {

    //用户的登陆
    public User   login(String  uname,String  pwd) throws  Exception;

}
