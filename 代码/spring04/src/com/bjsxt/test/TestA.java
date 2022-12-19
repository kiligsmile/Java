package com.bjsxt.test;

import com.bjsxt.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {


    public static void main(String[] args) {

        ApplicationContext  app =new ClassPathXmlApplicationContext("applicationContext.xml");

        //获得user对象
        User user = app.getBean("user", User.class);

        User user2 = app.getBean("user", User.class);

        System.out.println(user==user2);

        System.out.println(user);



    }

}
