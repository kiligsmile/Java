package com.bjsxt.controller;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/UserController")
public class UserController  extends HttpServlet{

    UserService us;
    @Override
    public void init() throws ServletException {

        String parameter = this.getServletContext().getInitParameter("abc");

        ApplicationContext  app =new ClassPathXmlApplicationContext(parameter);

         us = app.getBean("users", UserService.class);


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //【1】接受页面中的数据

        String uname = req.getParameter("uname");

        String pwd = req.getParameter("pwd");


        //【2】数据的处理
        User user = null;
        try {
            user = us.login(uname, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //【3】做出响应
        if(user!=null){

            resp.sendRedirect(req.getContextPath()+"/success.jsp");

        }else {

            req.setAttribute("msg","登陆失败");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }



    }
}
