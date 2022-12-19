package com.bjsxt.controller;

import com.bjsxt.pojo.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/StudentController")
public class StudentController extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决ajax响应的乱码
        resp.setContentType("text/html;charset=utf-8");
        //解决接受的中文乱码--post
        req.setCharacterEncoding("utf-8");

        //【1】接受前台页面的数据

        String name = req.getParameter("name");

        String phone = req.getParameter("phone");

        //【2】数据的处理--调用service

        StudentService  stus =new StudentServiceImpl();


        List<Student> list = stus.findMore(name, phone);


        //【3】给用户做出响应

        String json = new Gson().toJson(list);

        resp.getWriter().println(json);


    }
}
