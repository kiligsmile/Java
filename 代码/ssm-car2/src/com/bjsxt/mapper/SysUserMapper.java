package com.bjsxt.mapper;

import com.bjsxt.pojo.SysUser;

import java.util.List;

public interface SysUserMapper {

      //查询所有用户操作
      public List<SysUser>  selectAll();

      //用户的登陆
      public  SysUser   selectOne(String  loginname,String  pwd);

}
