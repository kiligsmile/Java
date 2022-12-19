package com.bjsxt.service;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysRoles;

import java.util.Map;

public interface SysRolesService {

    //查询所有菜单信息
    public Page<SysRoles>  findAll(int page, int rows);

    //添加菜单的操作
    public Map<String,String>  save(SysRoles sysRoles, Integer[] mmids);

    //修改操作
    public   Map<String,String>  change(SysRoles sysRoles, Integer[] mmids);


    //删除指定角色的操作
    public   Map<String,String>  remove(int rid);

}
