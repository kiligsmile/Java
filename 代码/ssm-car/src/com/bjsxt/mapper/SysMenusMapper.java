package com.bjsxt.mapper;

import com.bjsxt.pojo.SysMenus;
import com.bjsxt.pojo.Tree;

import java.util.List;

public interface SysMenusMapper {


    //查询所有菜单操作
    public List<SysMenus>  selectMore(int pid);

    //查询所有的菜单信息
    public   List<SysMenus>  selectAll();

    //新增菜单的操作
    public  int  insert(SysMenus sysMenus);

    public   int  update(int id);

    //修改菜单操作
    public   int   update2(SysMenus sysMenus);


    //查询指定的菜单下是否有子菜单
    public List<SysMenus>  findMore2(int id);

    //删除v操作
    public   int  delete(int id);


    public   List<Tree>  selectMore2(int pid);


    public List<SysMenus>  selectMore3(int pid, int rid);

}
