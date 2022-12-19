package com.bjsxt.service;

import com.bjsxt.pojo.BusRents;
import com.bjsxt.pojo.Page;

import java.util.Map;

public interface BusRentsService {

    //添加出租单信息
    public Map<String,String>   save(BusRents busRents);

    //查询多个检查单信息的操作
    public Page<BusRents>  findMore(BusRents busRents);

    //查询指定的出租单信息
    public BusRents findOne(String rentid);

}
