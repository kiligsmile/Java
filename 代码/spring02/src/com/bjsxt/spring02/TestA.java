package com.bjsxt.spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {

    public static void main(String[] args) {

        ApplicationContext  app=new ClassPathXmlApplicationContext("applicationContext2.xml");

        User user = app.getBean("user", User.class);

        System.out.println(user);

    }
}
