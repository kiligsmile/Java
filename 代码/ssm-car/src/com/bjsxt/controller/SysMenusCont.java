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
import java.util.Map;

@Controller
@RequestMapping("/SysMenusCont")
public class SysMenusCont {


    @Autowired
    SysMenusService  sysMenusService;


    //查指定角色下的菜单
    @RequestMapping("findMoreMenus3")
    @ResponseBody
    public List<Tree> findMoreMenus3(@RequestParam(defaultValue = "1") int id, HttpSession session){

      SysUser user = (SysUser) session.getAttribute("user");

        List<Tree> list = sysMenusService.findMore3(id,user.getType());

        return list;

    }


    //查询菜单的操作
    @RequestMapping("findMoreMenus1")
    @ResponseBody
    public List<Tree>  findMoreMenus1() {


        return  sysMenusService.findMore();

    }

        //删除指定菜单的操作
    @RequestMapping("removeMenus")
    @ResponseBody
    public Map<String,String> removeMenus(int  id) {

         return   sysMenusService.remove(id);

    }
        //修改指定菜单的操作
    @RequestMapping("changeMenus")
    @ResponseBody
    public Map<String,String> changeMenus(SysMenus sysMenus) {


        return  sysMenusService.change(sysMenus);

    }

        //添加指定菜单的操作
    @RequestMapping("saveMenus")
    @ResponseBody
    public Map<String,String> saveMenus(SysMenus sysMenus) {

        return  sysMenusService.save(sysMenus);

    }

        //查询所有菜单的操作
    @RequestMapping("findAllMenus")
    @ResponseBody
    public Page<SysMenus> findAllMenus(int page,int rows) {

        return  sysMenusService.findAll(page, rows);
    }



    @RequestMapping("findMoreMenus")
    @ResponseBody
    public List<Tree> findMoreMenus(@RequestParam(defaultValue = "1") int id){


        List<Tree> list = sysMenusService.findMore(id);

        return list;

    }


}
