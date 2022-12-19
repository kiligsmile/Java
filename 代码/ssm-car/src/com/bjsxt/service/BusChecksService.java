package com.bjsxt.service;

import com.bjsxt.pojo.BusChecks;

import java.util.Map;

public interface BusChecksService {


    //添加检查单信息
    public Map<String,String>  save(BusChecks busChecks, String carnumber);

}
