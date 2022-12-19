package com.bjsxt.service.impl;

import com.bjsxt.mapper.RmMapper;
import com.bjsxt.mapper.SysRolesMapper;
import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysRoles;
import com.bjsxt.service.SysRolesService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRolesServiceImpl implements SysRolesService {

    @Autowired
    SysRolesMapper  sysRolesMapper;

    @Autowired
    RmMapper  rmMapper;

    @Override
    public Page<SysRoles> findAll(int page, int rows) {

        com.github.pagehelper.Page page1 = PageHelper.startPage(page, rows);

        List<SysRoles> list = sysRolesMapper.selectAll();

        Page<SysRoles>  pg=new Page<>(list,page1.getTotal());


        return pg;
    }

    @Override
    @Transactional
    public Map<String, String> save(SysRoles sysRoles,Integer [] mmids) {

        Map<String,String>  map =new HashMap<>();

        try {
            //添加角色
            int insert = sysRolesMapper.insert(sysRoles);


            //添加角色对应的菜单

            for(Integer m:mmids){

                rmMapper.insert(sysRoles.getRoleid(),m);
            }



        } catch (Exception e) {

            map.put("errorMsg","添加失败");

        }

        return map;
    }

    @Override
    public Map<String, String> change(SysRoles sysRoles,Integer[] mmids) {

        Map<String,String>  map =new HashMap<>();
        try {

            //修改角色名称
            int update = sysRolesMapper.update(sysRoles);

            //删除指定角色下的菜单
            int delete = rmMapper.delete(sysRoles.getRoleid());

            //把选择的菜单ID增加到数据库中

            for(Integer  m:mmids){

                rmMapper.insert(sysRoles.getRoleid(),m);
            }

        } catch (Exception e) {
            map.put("errorMsg","修改失败");
        }

        return map;
    }

    @Override
    public Map<String, String> remove(int rid) {

        Map<String,String>  map =new HashMap<>();
        try {
            int delete = sysRolesMapper.delete(rid);

            map.put("success","删除成功");
        } catch (Exception e){

            map.put("errorMsg","删除失败");

        }

        return map;
    }
}
