package com.bjsxt.proxy2;

public class TestA {

    public static void main(String[] args) {


        MyInvoction  myInvoction=new MyInvoction();

        //设置房东对象
        myInvoction.setRm(new FD1());

        // 产生的中介  代理对象
        RentRoom proxy = (RentRoom) myInvoction.getproxy();

        proxy.zf();

        Util.writeProxyClassToHardDisk("E:/$Proxy11.class",new FD1().getClass().getInterfaces() );




    }
}
