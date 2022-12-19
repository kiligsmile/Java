package com.bjsxt.controller;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysRoles;
import com.bjsxt.service.SysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/SysRolesController")
public class SysRolesController {

    @Autowired
   private SysRolesService  sysRolesService;


    //查询所有的角色

    @RequestMapping("/findMore2")
    @ResponseBody
    public List<SysRoles> findMore2(){

        return   sysRolesService.findAll2();
    }


    //删除角色操作

    @RequestMapping("/removeRoles")
    @ResponseBody
    public   int  removeRoles(int rid){

          return   sysRolesService.remove(rid);
    }


    //修改角色操作

    @RequestMapping("/changeRoles")
    @ResponseBody
    public    int   changeRoles(SysRoles  sysRoles,Integer[] mids) throws Exception {

        return   sysRolesService.change(sysRoles, mids);

    }


    //添加角色的操作

    @RequestMapping("/saveRoles")
    @ResponseBody
    public   int   saveRoles(SysRoles  sysRoles,Integer[] mids) throws Exception {

        int save = sysRolesService.save(sysRoles,mids);

        return   save;

    }


    @RequestMapping("/findAllRoles")
    @ResponseBody
    public Page<SysRoles>   findAllRoles(int page,int rows){

        return   sysRolesService.findAll(page, rows);
    }

}
