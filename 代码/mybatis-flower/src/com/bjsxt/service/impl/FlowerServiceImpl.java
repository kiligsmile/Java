package com.bjsxt.service.impl;

import com.bjsxt.mapper.FlowerMapper;
import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FlowerServiceImpl  implements FlowerService {


    @Override
    public List<Flower> findAll() {

        List<Flower> list=null;

        SqlSession sqlSession=null;


        try {
            //【1】解析mybatis.xml
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

            //InputStream  inputStream1 =new FileInputStream("D:/asa/asa/mybatis.xml");


            //【2】获得sqlsessionFactory
            //SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);


            XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, null, null);

            SqlSessionFactory  factory=new DefaultSqlSessionFactory(parser.parse());

            //【3】获得session

             sqlSession = factory.openSession();

            //【4】调用mapper方法

            FlowerMapper mapper = sqlSession.getMapper(FlowerMapper.class);


            list = mapper.selectAll();

            // 注意  如果做的是增删改  的操作一定要 sqlSession.commit();


        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            sqlSession.close();
        }


        return list;
    }

}
