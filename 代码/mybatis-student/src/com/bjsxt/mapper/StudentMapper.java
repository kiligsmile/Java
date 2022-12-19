package com.bjsxt.mapper;

import com.bjsxt.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询多个的操作
    public List<Student>   selectMore(String   name,String  phone);

}
