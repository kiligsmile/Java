package com.bjsxt.controller;

import com.bjsxt.pojo.Page;
import com.bjsxt.pojo.SysMenus;
import com.bjsxt.pojo.SysUser;
import com.bjsxt.pojo.Tree;
import com.bjsxt.service.SysMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/SysMenusController")
public class SysMenusController {

    @Autowired
    private SysMenusService  sysMenusService;

    //删除菜单的操作

    @RequestMapping("/removeMenus")
    @ResponseBody
    public  int  removeMenus(int id){
        return   sysMenusService.remove(id);

    }


    //修改菜单操作
    @RequestMapping("/changeMenus")
    @ResponseBody
    public   int  changeMenus(SysMenus  sysMenus,int beforPid){

        return   sysMenusService.change(sysMenus,beforPid);

    }



    //添加菜单的操作

    @RequestMapping("/saveMenus")
    @ResponseBody
    public   int  saveMenus(SysMenus  sysMenus){

        return   sysMenusService.save(sysMenus);
    }


    //查询所有菜单信息
    @RequestMapping("/findAllMenus")
    @ResponseBody
    public Page<SysMenus>   findAllMenus(int  page,int rows){

        return   sysMenusService.findAll(page, rows);
    }


    @RequestMapping("/findMoreMenus")
    @ResponseBody
    public List<Tree> findMoreMenus(@RequestParam(defaultValue = "1") int  id){

       return   sysMenusService.findMore(id);
    }

    @RequestMapping("/findMoreMenus3")
    @ResponseBody
    public List<Tree> findMoreMenus3(@RequestParam(defaultValue = "1") int  id, HttpSession  session){

        SysUser user = (SysUser) session.getAttribute("user");


        return   sysMenusService.findMore3(id,user.getType());
    }

    @RequestMapping("/findMoreMenus2")
    @ResponseBody
    public List<Tree> findMoreMenus2(){

        return   sysMenusService.findMore2();
    }

}
