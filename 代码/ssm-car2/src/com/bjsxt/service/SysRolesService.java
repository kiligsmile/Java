package com.bjsxt.service;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysRoles;

import java.util.List;

public interface SysRolesService {

    //查询所有角色信息
    public Page<SysRoles>   findAll(int  page,int rows);

    //添加角色操作
    public   int    save(SysRoles  sysRoles,Integer[] mids) throws Exception;

    //修改角色的操作
    public   int    change(SysRoles  sysRoles,Integer[]  mids) throws Exception;

    //删除角色操作
    public   int   remove(int rid);

    public List<SysRoles>   findAll2();

}
