package com.bjsxt.service.impl;

import com.bjsxt.mapper.BusCarsMapper;
import com.bjsxt.mapper.BusRentsMapper;
import com.bjsxt.pojo.BusRents;
import com.bjsxt.pojo.Page;
import com.bjsxt.service.BusRentsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRentsServiceImpl  implements BusRentsService {

    @Autowired
    private BusRentsMapper  busRentsMapper;

    @Autowired
    private BusCarsMapper  busCarsMapper;

    @Override
    public int save(BusRents busRents) {

        //产生汽车出租单
        int insert = busRentsMapper.insert(busRents);

        //修改车辆的出租状态
        int i = busCarsMapper.update2(busRents.getCarnumber());

        if(insert>0&&i>0){
            return 1;
        }


        return 0;
    }

    @Override
    public Page<BusRents> findMore(int page,int rows,BusRents busRents) {

        com.github.pagehelper.Page page1 = PageHelper.startPage(page, rows);

        List<BusRents> list = busRentsMapper.selectMore(busRents);

        Page<BusRents>  pg =new Page<>(list,page1.getTotal());

        return pg;
    }

    @Override
    public BusRents findOne(String rentid) {
        return busRentsMapper.selectOne(rentid);
    }
}
