package com.bjsxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJ {


    @Before("execution(* com.bjsxt.pojo.Admin.a())")
    public   void    beforAdvice(){

        System.out.println("前置通知");
    }

    @After("execution(* com.bjsxt.pojo.Admin.a())")
    public  void   afterAdvice(){
        System.out.println("后置通知");
    }

    @Around("execution(* com.bjsxt.pojo.Admin.a())")
    public   Object   runAdvice(ProceedingJoinPoint  point) throws Throwable {

        System.out.println("环绕通知--前");


        Object o = point.proceed();

        System.out.println("环绕通知--后");

        return o;

    }

    public   void   throwsAdvice(){


        System.out.println("异常通知");
    }

}
