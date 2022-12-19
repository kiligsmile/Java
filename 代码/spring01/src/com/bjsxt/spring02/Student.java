package com.bjsxt.spring02;

public class Student  {


    private    int  age;

    private   String  name;

    private    String   sex;

    public Student(int age, String name, String sex) {
        System.out.println("student有参构造");
        this.age = age;
        this.name = name;
        this.sex = sex;
    }


    public Student(int a,String b) {
        System.out.println("student有参构造1111");

    }

    public Student(String b,int a) {
        System.out.println("student有参构造2222");

    }

    public Student(){
        System.out.println("student无参构造");
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
