package com.bjsxt.spring01;

public class Student {

    private   String  name;

    private   String   sex;

    private   int  age;

    private   Clazz  clazz;



    public Student(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student(String name, String sex, int age, Clazz clazz) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.clazz = clazz;
    }

    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {

        System.out.println("setClazz");
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", clazz=" + clazz +
                '}';
    }
}
