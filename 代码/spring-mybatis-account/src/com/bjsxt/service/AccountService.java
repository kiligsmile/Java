package com.bjsxt.service;

import com.bjsxt.pojo.Account;

public interface AccountService {

    //查询银行信息操作
    public Account    findOne(String  cno,String  pwd,String money);

    //用户转账操作
    public   int   change(String  outcno,String incno,int money);

}
