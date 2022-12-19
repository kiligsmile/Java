package com.bjsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//可以自动的扫描当前包所在类或者子类中所在的类
@SpringBootApplication
public class MyApplication {


    public static void main(String[] args) {


        SpringApplication.run(MyApplication.class,args);

    }
}
