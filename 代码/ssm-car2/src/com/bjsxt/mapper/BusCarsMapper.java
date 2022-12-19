package com.bjsxt.mapper;

import com.bjsxt.pojo.BusCars;

import java.util.List;

public interface BusCarsMapper {

    //车辆信息查询
    public List<BusCars>  selectAll();

    //车辆信息添加
    public   int   insert(BusCars  busCars);

    //车辆信息修改操作
    public   int  update(BusCars  busCars);

    //汽车删除操作
    public   int   delete(String  carnumber);

    //查询可以出租的车辆信息

    public    List<BusCars>  selectMore();

    //修改汽车状态
    public   int   update2(String  carnumber);

    //修改汽车状态
    public   int   update3(String  carnumber);

    //查询指定车辆信息
    public   BusCars  selectOne(String   carnumber);

}
