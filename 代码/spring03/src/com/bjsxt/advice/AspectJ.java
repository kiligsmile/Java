package com.bjsxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectJ {


    public   void    beforAdvice(){


        System.out.println("前置通知");

    }

    public  void   afterAdvice(){
        System.out.println("后置通知");
    }

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
