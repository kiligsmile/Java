package com.bjsxt.test;

import com.bjsxt.pojo.Admin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestB {

    public static void main(String[] args) {

        ApplicationContext  app =new ClassPathXmlApplicationContext("applicationContext2.xml");


        Admin admin = app.getBean("admin", Admin.class);

        admin.a();


    }

}
