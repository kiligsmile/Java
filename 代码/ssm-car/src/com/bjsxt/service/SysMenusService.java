package com.bjsxt.service;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysMenus;
import com.bjsxt.pojo.Tree;

import java.util.List;
import java.util.Map;

public interface SysMenusService {

    //查询指定菜单操作
    public List<Tree>  findMore(int pid);

    //查询所有菜单信息
    public Page<SysMenus>  findAll(int page, int rows);

    //添加菜单操作
    public Map<String,String>   save(SysMenus sysMenus);

    //修改菜单的操作
    public  Map<String,String>  change(SysMenus sysMenus);

    //删除指定菜单的操作
    public  Map<String,String>  remove(int id);

    //查询树形菜单B操作
    public  List<Tree>   findMore();

    //查询指定角色下的菜单
    public   List<Tree>  findMore3(int pid, int rid);

}
