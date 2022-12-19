package com.bjsxt.mapper;

import com.bjsxt.pojo.Account;

import javax.xml.ws.Service;

public interface AccountMapper {

    //多条件查询操作
    public Account   selectOne(String  cno,String  pwd,String   money);

    //修改操作A
    public   int   update(String outcno, int  money);

    //修改操作B
    public   int   update2(String incno, int  money);

}
