package com.bjsxt.mapper;

import com.bjsxt.pojo.Leave;

import java.util.List;

public interface LeaveMapper {

    //查询所有请假记录
    public List<Leave>   selectAll();


    //删除操作
    public   int  delete(int id);

}
