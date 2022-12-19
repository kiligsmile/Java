package com.bjsxt.service;

import com.bjsxt.pojo.BusCustomers;

public interface BusCustomersService {


    //查询指定用户操作
    public BusCustomers findOne(String identity);
}
