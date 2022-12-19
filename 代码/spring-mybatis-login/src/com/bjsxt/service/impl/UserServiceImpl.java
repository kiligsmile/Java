package com.bjsxt.service.impl;

import com.bjsxt.mapper.UserMapper;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("users")
public class UserServiceImpl  implements UserService {

    @Autowired
    private   UserMapper  userMapper;

    @Override
    public User login(String uname, String pwd) throws  Exception {

        //执行添加
        try {
            userMapper.insert(new User(0,"sxt","123"));

            userMapper.insert(new User(0,"sxt222229","123"));
        } catch (Exception e) {

            throw   new Exception();
        }


        return userMapper.selectOne(uname, pwd);
    }


}
