package com.bjsxt.service;

import com.bjsxt.pojo.BusCars;
import com.bjsxt.pojo.Page;

import java.util.List;
import java.util.Map;

public interface BusCarsService {

    //查询所有车辆信息
    public Page<BusCars>  findAll(int page, int rows);

    //添加车辆信息操作
    public Map<String,String>   save(BusCars busCars);

    //删除车辆信息
    public  Map<String,String>   remove(String carnumber);

    //修改车辆信息
    public  Map<String,String>  change(BusCars busCars);

    //查询指定车辆信息
    public   Page<BusCars> findMore(int page, int rows);

    //查询指定车辆的信息
    public  BusCars   findOne(String carnumber);


    //图表统计
    public List  eaCount();
}
