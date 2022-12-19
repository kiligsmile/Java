package com.bjsxt.service.impl;

import com.bjsxt.mapper.SysLogLoginMapper;
import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysLogLogin;
import com.bjsxt.service.SysLogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogLoginServiceImpl implements SysLogLoginService {


    @Autowired
    SysLogLoginMapper  sysLogLoginMapper;

    @Override
    public Page<SysLogLogin> findAll() {

        List<SysLogLogin> list = sysLogLoginMapper.selectAll();

        Page<SysLogLogin>  pg=new Page<>();
        pg.setRows(list);

        return pg;
    }
}
