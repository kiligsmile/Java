package com.bjsxt.mapper;

import java.util.List;

public interface RmMapper {

    //给角色赋予菜单
    public   int  insert(int rid, int mid);

    //查询指定角色下的菜单
    public List<Integer>  selectMore(int rid);

    //删除指定角色下的菜单
    public   int   delete(int rid);
}
