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

import java.util.List;

@Service
public class SysRolesServiceImpl  implements SysRolesService {

    @Autowired
    private SysRolesMapper  sysRolesMapper;

    @Autowired
    private RmMapper  rmMapper;

    @Override
    public Page<SysRoles> findAll(int page, int rows) {

        com.github.pagehelper.Page page1 = PageHelper.startPage(page, rows);

        List<SysRoles> list = sysRolesMapper.selectAll();

        Page<SysRoles>  pg=new Page<>(list,page1.getTotal());

        return  pg;
    }

    @Override
    @Transactional
    public int save(SysRoles sysRoles,Integer[] mids) throws Exception {
        int insert = 0;
        try {
            //添加角色操作
            insert = sysRolesMapper.insert(sysRoles);

            //给角色赋予菜单
            for(Integer  mid:mids){

                rmMapper.insert(sysRoles.getRoleid(),mid);

            }
            insert=1;
        } catch (Exception e) {

            throw  new Exception();
        }

        return insert;
    }

    @Override
    public int change(SysRoles sysRoles,Integer[]  mids) throws Exception {

        int  update=0;

        try {
            //修改角色的操作
            int i = sysRolesMapper.update(sysRoles);

            //删除指定角色下的菜单
            int delete = rmMapper.delete(sysRoles.getRoleid());

            //给角色重新授权
            for(Integer  mid:mids){
                rmMapper.insert(sysRoles.getRoleid(),mid);
            }
            update=  1;
        } catch (Exception e) {
           throw   new Exception();
        }


        return update;
    }

    @Override
    public int remove(int rid) {
        return sysRolesMapper.delete(rid);
    }

    @Override
    public List<SysRoles> findAll2() {
        return sysRolesMapper.selectAll();
    }
}
