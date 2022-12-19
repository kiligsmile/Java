package com.bjsxt.service.impl;

import com.bjsxt.mapper.SysMenusMapper;
import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysMenus;
import com.bjsxt.pojo.Tree;
import com.bjsxt.service.SysMenusService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenusServiceImpl  implements SysMenusService {

    @Autowired
    private SysMenusMapper  sysMenusMapper;


    @Override
    public List<Tree> findMore(int pid) {

        List<SysMenus> list = sysMenusMapper.selectMore(pid);

        List<Tree>   list2=new ArrayList<>();
        for(SysMenus  m:list){

            Tree  tree=new Tree(m.getId(),m.getName(),m.getOpen()==1?"open":"closed",m.getUrl());

            list2.add(tree);
        }

        return list2;
    }

    @Override
    public List<Tree> findMore3(int pid, int rid) {

        List<SysMenus> list = sysMenusMapper.selectMore3(pid, rid);

        List<Tree>   list2=new ArrayList<>();
        for(SysMenus  m:list){

            Tree  tree=new Tree(m.getId(),m.getName(),m.getOpen()==1?"open":"closed",m.getUrl());

            list2.add(tree);
        }

        return list2;
    }

    @Override
    public Page<SysMenus> findAll(int page, int rows) {

        com.github.pagehelper.Page page1 = PageHelper.startPage(page, rows);

        List<SysMenus> list = sysMenusMapper.selectAll();

        Page<SysMenus>  pg =new Page<>(list,page1.getTotal());

        return pg;
    }

    @Override
    @Transactional
    public int save(SysMenus sysMenus) {

        //添加菜单的节点
        int insert = sysMenusMapper.insert(sysMenus);

        //修改当前节点父节点的状态
        int update = sysMenusMapper.update(sysMenus.getPid(),0);

        if(insert>0&&update>0){
            return 1;
        }



        return 0;
    }

    @Override
    public int change(SysMenus sysMenus,int beforPid) {

        //修改菜单的信息
        int i = sysMenusMapper.update2(sysMenus);


        //修改菜单的状态
        int update = sysMenusMapper.update(sysMenus.getPid(), 0);

        //修改之前的父节点状态
        List<SysMenus> list = sysMenusMapper.selectMore(beforPid);

        if(list.size()<=0){
            sysMenusMapper.update(beforPid, 1);
        }


        if(i>0&&update>0){
            return 1;
        }


        return 0;
    }

    @Override
    public int remove(int id) {

        //查询当前节点下是否含有子菜单

        List<SysMenus> list = sysMenusMapper.selectMore(id);

        if(list.size()>0){
            return  -100;
        }

        //删除当前的菜单
        int delete = sysMenusMapper.delete(id);


        return delete;
    }

    @Override
    public List<Tree> findMore2() {

        //一级菜单
        List<Tree> list = sysMenusMapper.selectMore2(1);

        for(Tree  t:list){

            //二级菜单
            List<Tree> list1 = sysMenusMapper.selectMore2(t.getId());

            t.setChildren(list1);
        }

        return list;
    }
}
