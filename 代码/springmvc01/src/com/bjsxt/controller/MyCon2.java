package com.bjsxt.controller;

import com.bjsxt.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

@Controller
@RequestMapping("MyCon2")
public class MyCon2 {

     /**
      * Restful  数据传输
      *
      * http://127.0.0.1:8888/springmvc01/MyCon2/demo5?name=sxt&pid=123
      *
      * http://127.0.0.1:8888/springmvc01/MyCon2/demo5/sxt/123
      * */

     @RequestMapping("demo5/{name}/{pid}/{a}/{b}")
     public    String    demo5(@PathVariable String name , @PathVariable String pid){

         System.out.println(name+"---"+pid);

         return  "/success.jsp";
     }


    /*
    *  java.sql.Date :只是含有年月日 ，不含有时分秒
    *
    *  java.util.Date:包含年月日时分秒
    *
    *  @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    *
    *  使用了非空的校验
    *
    * */

    @RequestMapping("demo4")
    public   String   demo4(@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss") Date birth,String[]  hobby){

        System.out.println(birth+"--"+hobby[0]);

        return  "/success.jsp";
    }


    /**
     * 接受参数方式三
     *    直接使用对象进行值的接受
     *    注意：
     *       form表单的name属性必须和实体类中的属性名称保持一致
     * */

    @RequestMapping("demo3")
    public   String   demo3(User user) {

        System.out.println(user);

        return  "/success.jsp";
    }

        /**
         * 接受参数方式二：
         *   接受的参数都可以当作控制单元的形参进行接受
         *   注意
         *     控制单元的形参的名称必须和表单的name属性保持一致
         *
         *    400:页面传递的数据类型转换错误
         * */

    @RequestMapping("demo2")
    public   String   demo2(String  name,int age){

        System.out.println(name+"--"+age);

        return "/success.jsp";
    }



    /**
     * 接受参数方式一：
     *
     * String name = req.getParameter("name");
     *
     * */
    @RequestMapping("demo1")
    public   String  demo1(HttpServletRequest  req, HttpSession  session){

        String[] hobbies = req.getParameterValues("hobby");

        String s = Arrays.toString(hobbies);

        String name = req.getParameter("name");

        String age = req.getParameter("age");

        Integer.parseInt(age);

        System.out.println("name:"+name+"--age:"+age);

        return "/success.jsp";


    }

}
