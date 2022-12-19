package com.bjsxt.mapper;

import java.util.List;

public interface RmMapper {

    //给角色授权
    public   int   insert(int rid,int mid);

    //查询指定角色下的菜单ID
    public List<Integer>  selectMid(int rid);

    //删除角色-菜单操作
    public   int   delete(int  rid);

}
