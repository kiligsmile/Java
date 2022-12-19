package com.bjsxt.service.impl;

import com.bjsxt.mapper.BusCarsMapper;
import com.bjsxt.mapper.BusChecksMapper;
import com.bjsxt.mapper.BusRentsMapper;
import com.bjsxt.pojo.BusChecks;
import com.bjsxt.service.BusChecksService;
import com.bjsxt.service.BusRentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class BusChecksServiceImpl implements BusChecksService {

    @Autowired
    BusChecksMapper  busChecksMapper;

    @Autowired
    BusRentsMapper busRentsMapper;

    @Autowired
    BusCarsMapper  busCarsMapper;

    @Override
    @Transactional()
    public Map<String, String> save(BusChecks busChecks,String  carnumber) {


        Map<String, String>  map =new HashMap<>();

        try {
            int insert = busChecksMapper.insert(busChecks);

            //修改出租单的状态
            busRentsMapper.update(busChecks.getRentid());

            //修改车辆的出租状态
            busCarsMapper.update3(carnumber);
        } catch (Exception e) {

            map.put("errorMsg","入库失败");

            throw   new RuntimeException();

        }

        return map;
    }
}
