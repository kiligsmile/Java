package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/MyCon2")
public class MyCon2 {


    public ModelAndView   demo4(HttpServletRequest  req){

         ModelAndView mv=new ModelAndView();

         //转发一
         mv.setViewName("forward:/index.jsp");
        //重定向一
         mv.setViewName("redirect:/index.jsp");

         //转发二
         mv.setView(new InternalResourceView("/index.jsp"));
         //重定向二
         mv.setView(new RedirectView(req.getContextPath()+"/index.jsp"));

         return   mv;
    }


    /**转发和重定向的底层*/

    @RequestMapping("demo3")
    public View   demo3(HttpServletRequest  req){

        //转发
        //View   v=new InternalResourceView("/index.jsp");

        //重定向
        View  v =new RedirectView(req.getContextPath()+"/index.jsp");

        return  v;
    }



    /***
     * 重定向: return  "redirect:index.jsp";
     *
     *  A、相对路径 ：支持  ../
     *
     *  B、根路径:  支持的    /--上下文
     *
     *  C、绝对路径:支持的
     */
    @RequestMapping("demo2")
    public    String    demo2(){

          return  "redirect:http://www.bjsxt.com";
      }


    /**
     * 转发  默认书写是转发
     * return "forward:/index.jsp";
     *
     * 路径支持的方式
     *   A、相对路径 支持的 ，但是这个相对地址是相对于URL地址栏来说的，使用起来不是很方便
     *
     *   B、根路径  支持的  /--上下文
     *
     *   C、绝对路径：不支持的  转发是服务器内部的跳转
     *
     * */
    @RequestMapping("/demo1")
    public  String  demo1(){

        System.out.println("进入控制单元");

        return "forward:http://www.bjsxt.com";

    }

}
