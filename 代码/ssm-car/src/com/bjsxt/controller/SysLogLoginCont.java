package com.bjsxt.controller;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysLogLogin;
import com.bjsxt.service.SysLogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("SysLogLoginCont")
public class SysLogLoginCont {


    @Autowired
    SysLogLoginService  sysLogLoginService;



    @RequestMapping("LogLoginfindAll")
    @ResponseBody
    public Page<SysLogLogin>  LogLoginfindAll(){

        return  sysLogLoginService.findAll();

    }

}
