package com.bjsxt.service;

import com.bjsxt.pojo.Leave;

import java.util.List;

public interface LeaveService {

    //查询所有请假信息
    public List<Leave>   findAll();

    //删除信息操作
    public   int  remove(int  id);

}
