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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysMenusServiceImpl implements SysMenusService {

     @Autowired
     SysMenusMapper  sysMenusMapper;


    @Override
    public List<Tree> findMore(int pid) {

        List<SysMenus> list = sysMenusMapper.selectMore(pid);

        List<Tree>   list2=new ArrayList<>();
        for(SysMenus  sym:list){

            Tree  tr=new Tree(sym.getId(), sym.getName(), (sym.getOpen()==1?"open":"closed") , sym.getUrl());

            list2.add(tr);
        }


        return list2;
    }

    @Override
    public Page<SysMenus> findAll(int page, int rows) {

        com.github.pagehelper.Page page1 = PageHelper.startPage(page, rows);

        List<SysMenus> list = sysMenusMapper.selectAll();

        Page<SysMenus>  pg=new Page<>(list,page1.getTotal());


        return pg;
    }

    @Override
    @Transactional
    public Map<String, String> save(SysMenus sysMenus) {

        Map<String, String>  map =new HashMap<>();

        try {
            int insert = sysMenusMapper.insert(sysMenus);

            int update = sysMenusMapper.update(sysMenus.getPid());


        } catch (Exception e) {

            e.printStackTrace();

            map.put("errorMsg","添加失败");

        }

        return map;
    }

    @Override
    public Map<String, String> change(SysMenus sysMenus) {

        Map<String, String>  map =new HashMap<>();
        try {
            int i = sysMenusMapper.update2(sysMenus);

            sysMenusMapper.update(sysMenus.getPid());
        } catch (Exception e) {
            map.put("errorMsg","添加失败");
        }


        return map;
    }

    @Override
    public Map<String, String> remove(int id) {


        Map<String, String> map =new HashMap<>();

        try {
            List<SysMenus> list = sysMenusMapper.findMore2(id);

            if(list.size()>0){
                //不可以删除

                map.put("errorMsg","该菜单下有对应的子菜单,无法删除");
            }else{

                sysMenusMapper.delete(id);
                map.put("success","删除成功");
            }
        } catch (Exception e) {

            map.put("errorMsg","删除失败");
        }


        return map;
    }

    @Override
    public List<Tree> findMore() {

        //一级菜单的集合
        List<Tree> list = sysMenusMapper.selectMore2(1);

        for(Tree  tr:list){

            //二级菜单的集合
            List<Tree> list2 = sysMenusMapper.selectMore2(tr.getId());

            tr.setChildren(list2);
        }

        return list;
    }

    @Override
    public List<Tree> findMore3(int pid, int rid) {

        List<SysMenus> list = sysMenusMapper.selectMore3(pid, rid);

        List<Tree>   list2=new ArrayList<>();
        for(SysMenus  sym:list){

            Tree  tr=new Tree(sym.getId(), sym.getName(), (sym.getOpen()==1?"open":"closed") , sym.getUrl());

            list2.add(tr);
        }

        return list2;
    }

    /*@Override
    public List<Tree> findMore() {

        //一级菜单
        List<SysMenus> list = sysMenusMapper.selectMore(1);


        List<Tree>   li=new ArrayList<>();
        for(SysMenus   sysMenus:list){


            Tree  tree=new Tree();
            tree.setId(sysMenus.getId());

            tree.setText(sysMenus.getName());

            //二级菜单
            List<SysMenus> list2 = sysMenusMapper.selectMore(sysMenus.getId());

            List<Tree>   li2=new ArrayList<>();
            for (SysMenus  sysMenus1:list2){

                Tree  tr =new Tree();

                tr.setId(sysMenus1.getId());

                tr.setText(sysMenus1.getName());

                li2.add(tr);

            }

            tree.setChildren(li2);


            li.add(tree);

        }


        return li;
    }*/
}
