package com.bjsxt.service;

import com.bjsxt.pojo.Student;

import java.util.List;

public interface StudentService {

       //多条件查询的操作
    public List<Student>   findMore(String  name,String  phone);

}
