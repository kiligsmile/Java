package com.bjsxt.service.impl;

import com.bjsxt.mapper.SysUserMapper;
import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysUser;
import com.bjsxt.service.SysUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl  implements SysUserService {

    @Autowired
    private SysUserMapper  sysUserMapper;

    @Override
    public Page<SysUser> findAll(int page, int rows) {

        com.github.pagehelper.Page page1 = PageHelper.startPage(page, rows);

        List<SysUser> list = sysUserMapper.selectAll();

        Page<SysUser>  pg =new Page<>(list,page1.getTotal());

        return  pg;
    }

    @Override
    public SysUser login(String loginname, String pwd) {
        return sysUserMapper.selectOne(loginname, pwd);
    }
}
