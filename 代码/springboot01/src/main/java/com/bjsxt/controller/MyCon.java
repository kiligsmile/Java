package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyCon {

        @RequestMapping("/demo1")
        @ResponseBody
       public    String     demo1(){


           return  "springBoot";
       }

}
