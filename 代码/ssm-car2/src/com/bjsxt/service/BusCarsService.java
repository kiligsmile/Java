package com.bjsxt.service;

import com.bjsxt.pojo.BusCars;
import com.bjsxt.pojo.Page;

public interface BusCarsService {

    //查询车辆信息
    public Page<BusCars> findAll(int page,int rows);

    //添加车辆信息
    public   int   save(BusCars busCars);

    //修改车辆信息
    public   int     change(BusCars  busCars);

    //删除车辆信息
    public   int   remove(String  carnumber);

    //查询可以出租车辆信息
    public   Page<BusCars>  findMore(int page,int rows);


    //查询指定车辆信息
    public  BusCars   findOne(String  carnumber);

}
