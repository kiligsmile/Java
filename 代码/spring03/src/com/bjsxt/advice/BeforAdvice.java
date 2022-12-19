package com.bjsxt.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforAdvice  implements MethodBeforeAdvice{

    /**
     * method:目标切点的方法对象
     *
     * objects:传递过来的参数列表
     *
     * o：切点所在的类的对象
     * */

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        System.out.println(method+"--"+objects[0]+"--"+o);

        System.out.println("扩展功能A--前置");

    }
}
