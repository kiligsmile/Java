package com.bjsxt.advice;

import com.bjsxt.pojo.SysLogLogin;
import com.bjsxt.service.SysLogLoginService;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
public class AfterAdvice  implements AfterReturningAdvice {


    @Autowired
    SysLogLoginService  sysLogLoginService;


    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {


        HttpServletRequest  req  = (HttpServletRequest) objects[2];


        //远程的IP地址  如果是localhost: 00:00:00:00
        String addr = req.getRemoteAddr();


        //执行添加的操作

        //SysLogLogin  sysLogLogin=new SysLogLogin(0, objects[0], String loginid, Date logintime);






    }
}
