package com.bjsxt.spring03;

public class Student  implements  People {
    @Override
    public void eat() {
        System.out.println("学生eat");
    }

    @Override
    public void run() {

        System.out.println("学生run");
    }
}
