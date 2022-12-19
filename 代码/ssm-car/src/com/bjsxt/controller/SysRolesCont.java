package com.bjsxt.controller;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysRoles;
import com.bjsxt.service.SysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/SysRolesCont")
public class SysRolesCont {

     @Autowired
    SysRolesService  sysRolesService;


    @RequestMapping("sysRolesRemove")
    @ResponseBody
    public Map<String,String> sysRolesRemove(int  rid) {


          return   sysRolesService.remove(rid);


    }

    @RequestMapping("sysRoleschange")
    @ResponseBody
    public Map<String,String> sysRoleschange(SysRoles sysRoles,Integer[] mmids) {

      return  sysRolesService.change(sysRoles,mmids);

    }


    @RequestMapping("sysRolesSave")
    @ResponseBody
    public Map<String,String> sysRolesSave(SysRoles sysRoles,Integer[] mmids) {

        Map<String, String> map = sysRolesService.save(sysRoles,mmids);

        return map;

    }



        @RequestMapping("sysRolesFindAll")
     @ResponseBody
     public Page<SysRoles>   sysRolesFindAll(int page,int rows){

          return   sysRolesService.findAll(page,rows);
     }





}
