package com.bjsxt.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class RunAdvice implements MethodInterceptor {


    /**
     * methodInvocation  :切点的方法对象
     *
     * */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println(methodInvocation);

        System.out.println("环绕通知--前");


        Object o = methodInvocation.proceed();

        System.out.println("环绕通知--后");

        return o;
    }
}
