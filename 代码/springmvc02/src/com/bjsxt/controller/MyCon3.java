package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCon3 {

    //  http://127.0.0.1:8888/springmvc02/show


    @RequestMapping("/{path}")
    public   String   getPath(@PathVariable String path){

        return  path;
    }

    /***
     * demo11--->@RequestMapping("/demo11")-->@RequestMapping("/{path}")
     *
     *  再给用户做出响应的时候 直接return 的时候就不再默认是转发了，这个时候会经过自定义
     *  视图解析器
     *
     *  如果我们想要进行转发或者重定向 就必须
     *
     *  return "forward:index.jsp";

       return "redirect:index.jsp";
     *
     */


    @RequestMapping("/demo11")
    public   String    demo1(){

        System.out.println("进入了demo1方法");

        //return "forward:index.jsp";

        return "redirect:index.jsp";

    }
}
