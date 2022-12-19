package com.bjsxt.service;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysUser;

import javax.servlet.http.HttpServletRequest;

public interface SysUserService {


    //查询所有用户信息
    public Page<SysUser>   findAll();

    //用户登录操作
    public   SysUser    login(String loginname, String pwd, HttpServletRequest req);

}
