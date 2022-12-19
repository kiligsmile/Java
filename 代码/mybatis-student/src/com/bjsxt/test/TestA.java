package com.bjsxt.test;

import com.bjsxt.mapper.StudentMapper;
import com.bjsxt.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestA {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");


        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);


        List<Student> list = mapper.selectMore("zs", "'123'");


        System.out.println(list);


    }
}
