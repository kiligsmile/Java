package com.bjsxt.service;

import com.bjsxt.pojo.BusCustomers;

public interface BusCustomersService {

    //查询指定的用户
    public BusCustomers  findOne(String  identity);

}
