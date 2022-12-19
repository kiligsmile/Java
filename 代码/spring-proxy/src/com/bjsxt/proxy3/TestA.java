package com.bjsxt.proxy3;

public class TestA {

    public static void main(String[] args) {

        MyMethodIn   my =new MyMethodIn();

        FD1 proxy = (FD1) my.getProxy();

        proxy.zf();


    }
}
