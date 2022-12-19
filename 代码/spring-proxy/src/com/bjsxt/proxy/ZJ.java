package com.bjsxt.proxy;

public class ZJ  implements  RentRoom {

    private   int  money;

    public ZJ(int money) {
        this.money = money;
    }

    @Override
    public void zf() {

        System.out.println("收取介绍费500元");

        if(money<=800){
            //中介最后租的还是房东的房子
            FD1  fd=new FD1();

            fd.zf();

        }else  if(money<=1500){
            FD2  fd2=new FD2();

            fd2.zf();

        }


        System.out.println("收取卫生费400元");

    }
}
