package com.bjsxt.spring03;

public class Teacher implements  People {
    @Override
    public void eat() {
        System.out.println("老师eat");
    }

    @Override
    public void run() {

        System.out.println("老师run");

    }
}
