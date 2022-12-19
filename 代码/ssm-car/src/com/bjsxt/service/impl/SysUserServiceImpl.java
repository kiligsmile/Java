package com.bjsxt.service.impl;

import com.bjsxt.mapper.SysUserMapper;
import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysUser;
import com.bjsxt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    SysUserMapper  sysUserMapper;


    @Override
    public Page<SysUser> findAll() {

        List<SysUser> list = sysUserMapper.selectAll();

        Page<SysUser>  pg=new Page<>();

        pg.setRows(list);

        return pg;
    }

    @Override
    public SysUser login(String loginname, String pwd, HttpServletRequest req) {

        return sysUserMapper.selectOne(loginname,pwd);
    }
}
