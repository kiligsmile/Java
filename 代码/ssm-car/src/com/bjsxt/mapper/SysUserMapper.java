package com.bjsxt.mapper;

import com.bjsxt.pojo.SysUser;

import java.util.List;

public interface SysUserMapper {

    //查询用户操作
    public List<SysUser>  selectAll();

    //查询指定用户的操作
    public   SysUser   selectOne(String loginname, String pwd);

}
