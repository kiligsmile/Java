package com.bjsxt.service.impl;

import com.bjsxt.mapper.BusCustomersMapper;
import com.bjsxt.pojo.BusCustomers;
import com.bjsxt.service.BusCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusCustomersServiceImpl implements BusCustomersService {


    @Autowired
    BusCustomersMapper  busCustomersMapper;

    @Override
    public BusCustomers findOne(String identity) {
        return busCustomersMapper.selectOne(identity);
    }
}
