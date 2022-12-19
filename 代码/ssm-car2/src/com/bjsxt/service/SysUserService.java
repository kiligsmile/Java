package com.bjsxt.service;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysUser;

public interface SysUserService {

    //查询所有用户的操作
    public Page<SysUser>  findAll(int page,int rows);

    //用户登陆
    public   SysUser   login(String   loginname,String   pwd);

}
