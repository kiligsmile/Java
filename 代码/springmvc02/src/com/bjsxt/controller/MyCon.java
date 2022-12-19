package com.bjsxt.controller;

import com.bjsxt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MyCon {

    /**
     * 注意的内容
     * 【1】我们使用SpringMVC结合ajax的时候 把查询出来的内容直接返回即可
     *
     * 【2】需要在方法上增加@ResponseBody
     *
     * 【3】响应的结果集直接是JSON对象 不需要进行任何的转换
     * */

    @RequestMapping(value = "demo2",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public    User   demo2(){

        //【1】接受页面的数据


        //【2】数据的处理
        User  user=new User("lisi",20,"男");

        //【3】做出响应
         return  user;
    }



    /***
     *  这种方式响应的是json 字符串
     */


    @RequestMapping("/demo1")
    public  void    demo1(HttpServletResponse  resp, String  name, int age) throws IOException {

          resp.setContentType("text/html;charset=utf-8");

         //【1】接受页面数据

        //【2】数据处理
        User  user=new User("lisi",20,"男");

        //【3】给用户做出响应
        //String json = new Gson().toJson(user);

        //resp.getWriter().print(json);

    }

}
