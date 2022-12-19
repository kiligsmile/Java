package com.bjsxt.spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {


    public static void main(String[] args) {

        ApplicationContext  app =new ClassPathXmlApplicationContext("applicationContext.xml");

        Student stu = app.getBean("stu", Student.class);


        System.out.println(stu);

    }

}
