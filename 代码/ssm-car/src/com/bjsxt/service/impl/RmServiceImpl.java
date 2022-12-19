package com.bjsxt.service.impl;

import com.bjsxt.mapper.RmMapper;
import com.bjsxt.service.RmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RmServiceImpl  implements RmService{

    @Autowired
    RmMapper  rmMapper;

    @Override
    public List<Integer> findMore(int rid) {

        return rmMapper.selectMore(rid);
    }
}
