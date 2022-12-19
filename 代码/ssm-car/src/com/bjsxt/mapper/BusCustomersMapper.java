package com.bjsxt.mapper;

import com.bjsxt.pojo.BusCustomers;

public interface BusCustomersMapper {


    //查询指定用户的操作
    public BusCustomers  selectOne(String identity);

}
