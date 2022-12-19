package com.bjsxt.controller;

import com.bjsxt.pojo.BusCars;
import com.bjsxt.pojo.Page;
import com.bjsxt.service.BusCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/busCarsController")
public class BusCarsController {

     @Autowired
     private BusCarsService  busCarsService;

     //查询指定车辆的信息

     @RequestMapping("/findOneBusCars")
     @ResponseBody
     public  BusCars   findOneBusCars(String  carnumber){

          return  busCarsService.findOne(carnumber);
     }


     //可以出租车辆信息查询
     @RequestMapping("/findMoreBusCars")
     @ResponseBody
     public  Page<BusCars>  findMoreBusCars(int page,int rows){

          return   busCarsService.findMore(page, rows);
     }

     //车辆删除操作
     @RequestMapping("/removeBusCars")
     @ResponseBody
     public   int    removeBusCars(String  carnumber){

          return   busCarsService.remove(carnumber);
     }


     //车辆修改的操作
     @RequestMapping("/changeBusCars")
     @ResponseBody
     public   int  changeBusCars(BusCars  busCars){

           return   busCarsService.change(busCars);

     }


     //文件上传的操作
     @RequestMapping("/fileUpload")
     @ResponseBody
     public Map<String ,String> fileUpload(HttpServletRequest  request, MultipartFile  fil) throws IOException {

          Map<String,String>  map =new HashMap<>();

          try {
               String realPath = request.getServletContext().getRealPath("/imgs");

               File  file=new File(realPath);

               if(!file.exists()){

                    file.mkdirs();
               }

               String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));

               String uuid = UUID.randomUUID().toString();

               String  filename=uuid+substring;


               fil.transferTo(new File(file,filename));

             map.put("url",filename);

          } catch (Exception e) {
               e.printStackTrace();
          }

        return  map;
     }


     //添加车辆信息
     @RequestMapping("/saveBusCars")
     @ResponseBody
     public   int   saveBusCars(BusCars busCars){

         return  busCarsService.save(busCars);
     }

     //查询所有车辆信息
     @RequestMapping("/findAllBusCars")
     @ResponseBody
     public Page<BusCars>  findAllBusCars(int page,int rows){

           return   busCarsService.findAll(page, rows);
     }


}
