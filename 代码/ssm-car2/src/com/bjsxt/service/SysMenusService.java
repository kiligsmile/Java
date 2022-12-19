package com.bjsxt.service;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysMenus;
import com.bjsxt.pojo.Tree;

import java.util.List;

public interface SysMenusService {

    //查询菜单的操作
    public List<Tree>  findMore(int pid);

    //查询菜单的操作
    public List<Tree>  findMore3(int pid,int rid);


    //查询所有菜单的操作
    public Page<SysMenus>   findAll(int page,int rows);

    //添加菜单操作
    public   int   save(SysMenus  sysMenus);

    //修改菜单操作
    public   int   change(SysMenus  sysMenus,int beforPid);

    //删除菜单的操作
    public   int   remove(int  id);

    //查询所有菜单操作
    public   List<Tree>  findMore2();

}
