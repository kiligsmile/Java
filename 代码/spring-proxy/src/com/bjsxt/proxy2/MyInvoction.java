package com.bjsxt.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvoction implements InvocationHandler {

      private  RentRoom  rm;

    public void setRm(RentRoom rm) {
        this.rm = rm;
    }

    //动态获得代理类对象--中介

    /**
     * 参数一    ClassLoader   类加载器
     *
     * 参数二：  new Class[]{}
     *
     * 参数三： InvocationHandler
     *
     * */

    public  Object  getproxy(){


        return Proxy.newProxyInstance(MyInvoction.class.getClassLoader(),new Class[]{RentRoom.class},this);
    }

    /**
     * 租房的方法
     *
     * **/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("收取介绍费500元");

        Object invoke = method.invoke(rm, args);

        System.out.println("收取卫生费400元");


        return invoke;
    }
}
