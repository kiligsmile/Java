package com.bjsxt.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Date;

public class LogAdvice  implements AfterReturningAdvice{
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

        
        if(o!=null){

            String time = new Date().toLocaleString();

            System.out.println("用户:"+objects[0]+"在"+time+"进行登陆成功");
        }
    }
}
