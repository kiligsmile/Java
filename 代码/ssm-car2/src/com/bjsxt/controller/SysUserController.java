package com.bjsxt.controller;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysUser;
import com.bjsxt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/SysUserController")
public class SysUserController  {

    @Autowired
   private    SysUserService  sysUserService;

    @RequestMapping("/userLogin")
    @ResponseBody
    public   SysUser   userLogin(String  loginname, String  pwd, HttpSession  session){

        SysUser user = sysUserService.login(loginname, pwd);

        session.setAttribute("user",user);

        return  user ;
    }


    @RequestMapping("/findAllUsers")
    @ResponseBody
    public Page<SysUser>   findAllUsers(int  page,int rows){

        return   sysUserService.findAll(page, rows);

    }

}
