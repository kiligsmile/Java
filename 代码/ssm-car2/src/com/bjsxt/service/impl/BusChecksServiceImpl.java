package com.bjsxt.service.impl;

import com.bjsxt.mapper.BusCarsMapper;
import com.bjsxt.mapper.BusChecksMapper;
import com.bjsxt.mapper.BusRentsMapper;
import com.bjsxt.pojo.BusChecks;
import com.bjsxt.service.BusChecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusChecksServiceImpl  implements BusChecksService {

    @Autowired
    private BusChecksMapper  busChecksMapper;

    @Autowired
    private BusRentsMapper  busRentsMapper;


    @Autowired
    private BusCarsMapper  busCarsMapper;

    @Override
    @Transactional
    public int save(BusChecks busChecks,String carnumber) {

        //添加检查单信息
        int insert = busChecksMapper.insert(busChecks);

        //修改出租单状态
        int update = busRentsMapper.update(busChecks.getRentid());

        //修改车辆的状态
        int update3 = busCarsMapper.update3(carnumber);

        if(insert>0&&update>0&&update3>0){
            return 1;
        }

        return 0;
    }
}
