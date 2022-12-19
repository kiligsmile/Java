package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCon {


      @RequestMapping("bjsxt.action")
      public    String     demo1(){

          //[1]接受页面的数据
          System.out.println("数据接受完毕 name =123");

          //[2]数据的处理


          //[3]做出响应
          return "/success.jsp";

      }



}
