package com.bjsxt.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterAdvice implements AfterReturningAdvice {


    /**
     * o:切点方法的返回值
     *
     * method：切点所再的方法对象
     *
     * objects:切点中的参数列表
     *
     * o1:切点所在的类对象
     *
     * */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

        System.out.println(o+"--"+method+"--"+objects[0]+"--"+o1);

        System.out.println("功能扩展B--后置");


    }
}
