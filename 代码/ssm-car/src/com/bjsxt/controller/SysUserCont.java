package com.bjsxt.controller;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysUser;
import com.bjsxt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/SysUserCont")
public class SysUserCont {

    @Autowired
    SysUserService  sysUserService;


    @RequestMapping("userLogin")
    @ResponseBody
    public   boolean   userLogin(String uname, String  pwd, HttpSession session, HttpServletRequest  req){


        SysUser user = sysUserService.login(uname, pwd,req);

        if(user!=null){

            session.setAttribute("user",user);
            return  true;
        }else{

            return  false;
        }


    }


    @RequestMapping("sysUserFindAll")
    @ResponseBody
    public Page<SysUser>   sysUserFindAll(){

        return sysUserService.findAll();

    }
}
