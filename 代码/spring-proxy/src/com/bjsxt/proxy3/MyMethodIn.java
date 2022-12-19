package com.bjsxt.proxy3;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodIn implements MethodInterceptor{


    //动态产生代理对象
    public   Object   getProxy(){

        Enhancer  en=new Enhancer();

        //设置父类
        en.setSuperclass(FD1.class);

        //设置回滚函数
        en.setCallback(this);

        //使整个设置生效
        Object o = en.create();

        return   o;

    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("收取管理费500");

        //调用房东的租房方法
        Object o1 = methodProxy.invokeSuper(o, objects);

        System.out.println("收取卫生费400");


        return o1;
    }
}
