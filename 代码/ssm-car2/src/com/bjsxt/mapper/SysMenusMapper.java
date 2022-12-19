package com.bjsxt.mapper;

import com.bjsxt.pojo.SysMenus;
import com.bjsxt.pojo.Tree;

import java.util.List;

public interface SysMenusMapper {

    //菜单查询操作
    public List<SysMenus>  selectMore(int pid);

    //菜单查询操作
    public List<SysMenus>  selectMore3(int pid,int rid);

    //查询所有菜单的操作
    public   List<SysMenus>  selectAll();

    //添加菜单的操作
    public   int  insert(SysMenus  sysMenus);

    //修改菜单状态操作
    public   int   update(int id,int open);

    public   int   update2(SysMenus  sysMenus);

    //删除菜单的操作
    public   int  delete(int  id);


    //查询菜单操作2
    public  List<Tree>  selectMore2(int pid);

}
