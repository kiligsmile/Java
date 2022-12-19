package com.bjsxt.service.impl;

import com.bjsxt.mapper.BusCarsMapper;
import com.bjsxt.mapper.BusRentsMapper;
import com.bjsxt.pojo.BusRents;
import com.bjsxt.pojo.Page;
import com.bjsxt.service.BusRentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusRentsServiceImpl implements BusRentsService {

    @Autowired
    BusRentsMapper  busRentsMapper;

    @Autowired
    BusCarsMapper  busCarsMapper;





    @Override
    public Map<String, String> save(BusRents busRents) {

        Map<String, String>  map =new HashMap<>();
        try {
            //添加出租单信息
            busRentsMapper.insert(busRents);


            //修改出租车辆的状态
            busCarsMapper.update2(busRents.getCarnumber());

        } catch (Exception e) {
            map.put("errorMsg","添加失败");

        }

        return map;
    }

    @Override
    public Page<BusRents> findMore(BusRents busRents) {

        List<BusRents> list = busRentsMapper.selectMore(busRents);

        System.out.println(list);


        Page<BusRents> pg=new Page<>();

        pg.setRows(list);

        return pg;
    }

    @Override
    public BusRents findOne(String rentid) {
        return busRentsMapper.selectOne(rentid);
    }
}
