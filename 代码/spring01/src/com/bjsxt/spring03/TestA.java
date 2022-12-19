package com.bjsxt.spring03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {

    public static void main(String[] args) {


        /*People people = new Factory().getInstance("tea");

        people.eat();*/

        /*People tea = Factory.getInstance2("tea");*/


        ApplicationContext  app =new ClassPathXmlApplicationContext("applicationContext2.xml");

        People po = app.getBean("po", People.class);

        po.eat();


    }
}
