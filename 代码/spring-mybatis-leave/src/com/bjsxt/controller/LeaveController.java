package com.bjsxt.controller;

import com.bjsxt.pojo.Leave;
import com.bjsxt.service.LeaveService;
import com.google.gson.GsonBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/LeaveController")
public class LeaveController extends HttpServlet {

    LeaveService leaves;



     @Override
    public void init() throws ServletException {

        //*String config = this.getServletContext().getInitParameter("config");

        //ApplicationContext  app=new ClassPathXmlApplicationContext(config);*//*

        //方式二
         ApplicationContext  app=  WebApplicationContextUtils.getWebApplicationContext(getServletContext());

         leaves = app.getBean("leaves", LeaveService.class);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

          resp.setContentType("text/html;charset=utf-8");

        String method = req.getParameter("method");

        if("leaveFindAll".equals(method)){

            leaveFindAll(req,resp);

        }else  if("leaveRemove".equals(method)){

            leaveRemove(req,resp);
        }
    }

    private void leaveRemove(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int   id  =Integer.parseInt(req.getParameter("id"));

        int remove = leaves.remove(id);

        resp.getWriter().println(remove);


    }

    private void leaveFindAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {


         //【1】接受页面的数据


        //【2】数据的处理
        List<Leave> list = leaves.findAll();

        String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list);


        //【3】做出响应
        resp.getWriter().println(json);


    }
}
