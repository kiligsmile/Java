package com.bjsxt.controller;

import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
import com.bjsxt.service.impl.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/FlowerController")
public class FlowerController  extends HttpServlet{


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //【1】接受前台页面的数据


        //【2】数据处理--调用service
        FlowerService  fls =new FlowerServiceImpl();

        List<Flower> list = fls.findAll();


        //【3】给用户做出响应

        req.setAttribute("list",list);
        req.getRequestDispatcher("/showAll.jsp").forward(req,resp);
    }
}
