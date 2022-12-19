package com.bjsxt.service.impl;

import com.bjsxt.mapper.StudentMapper;
import com.bjsxt.pojo.Student;
import com.bjsxt.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {



    @Override
    public List<Student> findMore(String name, String phone) {


        List<Student> list=null;

        SqlSession session=null;

        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");


            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);


             session = factory.openSession();

            StudentMapper mapper = session.getMapper(StudentMapper.class);


            list = mapper.selectMore(name, phone);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            session.close();
        }


        return list;
    }
}
