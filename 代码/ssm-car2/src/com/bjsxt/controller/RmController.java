package com.bjsxt.controller;

import com.bjsxt.service.RmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/RmController")
public class RmController  {

    @Autowired
     private   RmService  rmService;


    @RequestMapping("/findMid")
    @ResponseBody
    public List<Integer>  findMid(int  rid){
        return   rmService.findMid(rid);
    }

}
