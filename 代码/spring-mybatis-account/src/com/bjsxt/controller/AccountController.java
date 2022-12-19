package com.bjsxt.controller;

import com.bjsxt.pojo.Account;
import com.bjsxt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/AccountController")
public class AccountController  extends HttpServlet{


    AccountService accounts;

    @Override
    public void init() throws ServletException {

        ApplicationContext  app = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

         accounts = app.getBean("accounts", AccountService.class);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getParameter("method");

        if("checkUser".equals(method)){

            checkUser(req,resp);
        }else if("inOutMoney".equals(method)){
            inOutMoney(req,resp);
        }

    }

    private void inOutMoney(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        String outcno = req.getParameter("outcno");


        String incno = req.getParameter("incno");

        int   money=  Integer.parseInt(req.getParameter("money"));

        int change = accounts.change(outcno, incno, money);

         if(change>0){
             resp.sendRedirect(req.getContextPath()+"/success.jsp");
         }else {

             req.setAttribute("msg","汇款失败");
             req.getRequestDispatcher("/account.jsp").forward(req,resp);
         }


    }

    //查询用户的操作
    private void checkUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

          //[1]接受页面的数据

        String cno = req.getParameter("cno");

        String pwd = req.getParameter("pwd");

        String  money =req.getParameter("money");

        //[2]数据的处理
        Account account = accounts.findOne(cno, pwd, money);

        //[3]做出响应
        if(account!=null){
            resp.getWriter().println(true);
        }else {
            resp.getWriter().println(false);
        }



    }
}
