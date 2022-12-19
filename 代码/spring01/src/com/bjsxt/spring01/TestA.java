package com.bjsxt.spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {


    public static void main(String[] args) {

       /* User  user =new User();

        user.eat();*/

       //[1]解析applicationContext.xml

        ApplicationContext  app =new ClassPathXmlApplicationContext("applicationContext.xml") ;

        //[2]获得user对象

        User us = (User) app.getBean("us");

        User us1 = app.getBean("us", User.class);


        us.eat();


    }

}
