package com.bjsxt.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {


    private   String   name;

    private   int  age;

    private   int  score;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date   birth;

    public User(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
