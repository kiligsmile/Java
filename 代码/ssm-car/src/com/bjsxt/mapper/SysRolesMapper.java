package com.bjsxt.mapper;

import com.bjsxt.pojo.SysRoles;

import java.util.List;

public interface SysRolesMapper {

    //查询所有角色操作
    public List<SysRoles>  selectAll();

    //添加角色的操作
    public   int    insert(SysRoles sysRoles);

    //修改操作
    public   int     update(SysRoles sysRoles);

    //删除操作
    public  int  delete(int rid);

}
