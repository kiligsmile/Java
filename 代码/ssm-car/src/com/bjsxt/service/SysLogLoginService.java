package com.bjsxt.service;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysLogLogin;

public interface SysLogLoginService {

      //查询所有登录日志信息
    public Page<SysLogLogin>   findAll();


}
