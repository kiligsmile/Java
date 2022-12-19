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
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/BusCarsCont")
public class BusCarsCont {

    @Autowired
    BusCarsService  busCarsService;

    //查询指定出租车辆信息
    @RequestMapping("eaCount")
    @ResponseBody
    public List eaCount() {

        return   busCarsService.eaCount();

    }

        //查询指定出租车辆信息
    @RequestMapping("findOneBusCars")
    @ResponseBody
    public BusCars  findOneBusCars(String  carnumber) {

        return  busCarsService.findOne(carnumber);

    }
    //查询可以出租车辆信息
    @RequestMapping("findMoreBusCars")
    @ResponseBody
    public Page<BusCars>  findMoreBusCars(int page,int rows) {

        Page<BusCars> pg = busCarsService.findMore(page, rows);

        return  pg;
    }

        //修改车辆信息
    @RequestMapping("changeBusCars")
    @ResponseBody
    public Map<String,String> changeBusCars(BusCars  busCars) {

        Map<String, String> map = busCarsService.change(busCars);

        return  map;
   }


        //删除车辆信息
    @RequestMapping("removeBusCars")
    @ResponseBody
    public Map<String,String> removeBusCars(String  carnumber) {

        Map<String, String> map = busCarsService.remove(carnumber);

        return  map;


    }

        //文件上传的操作
    @RequestMapping("fileUpload")
    @ResponseBody
    public Map<String,String> fileUpload(HttpServletRequest req, MultipartFile fil) {

        Map<String,String>  map =new HashMap<>();

        try {
            String realPath = req.getServletContext().getRealPath("/imgs");

            File   file=new File(realPath);

            if(!file.exists()){

                file.mkdirs();
            }

            String uuid = UUID.randomUUID().toString();

            String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));

            //filename
            String  filename =uuid+substring;


            fil.transferTo(new File(file,filename));

            map.put("success",filename);
        } catch (IOException e) {

            map.put("errorMsg","文件上传失败");

        }

        return  map;


    }



        //添加车辆信息

    @RequestMapping("saveBusCars")
    @ResponseBody
    public Map<String,String> saveBusCars(BusCars busCars){


        Map<String, String> map = busCarsService.save(busCars);

        return  map;
    }


    //查询所有车辆信息
    @RequestMapping("findAllBusCars")
    @ResponseBody
    public Page<BusCars>  findAllBusCars(int page,int rows){

        Page<BusCars> pg = busCarsService.findAll(page, rows);

        return  pg;
    }

}
