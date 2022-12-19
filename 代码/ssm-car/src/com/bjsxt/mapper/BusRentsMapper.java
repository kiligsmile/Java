package com.bjsxt.mapper;

import com.bjsxt.pojo.BusRents;

import java.util.List;

public interface BusRentsMapper {

    //添加汽车出租单信息
    public   int   insert(BusRents busRents);

    //查询指定的出租单信息的操作
    public List<BusRents>  selectMore(BusRents busRents);

    //查询指定出租单信息
    public  BusRents  selectOne(String rentid);

    //修改出租单的状态
    public  int   update(String rentid);

}
