package com.bjsxt.mapper;

import com.bjsxt.pojo.BusCars;

import java.util.List;

public interface BusCarsMapper {


    //查询所有车辆信息
    public List<BusCars> selectAll();

    //添加车辆信息
    public  int   insert(BusCars busCars);

    //删除车辆信息
    public  int   delete(String carnumber);

    //修改车辆的信息
    public   int    update(BusCars busCars);

    //查询指定车辆信息
    public   List<BusCars>  selectMore();

    //修改指定车辆信息
    public  int   update2(String carnumber);


    //修改指定车辆信息
    public  int   update3(String carnumber);

    //查询指定车辆信息
    public  BusCars   selectOne(String carnumber);


    //进行图表的统计
    public   List<BusCars> eaCount();





}
