package com.bjsxt.controller;

import com.bjsxt.pojo.BusRents;
import com.bjsxt.pojo.Page;
import com.bjsxt.service.BusRentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/BusRentsController")
public class BusRentsController  {

    @Autowired
    private BusRentsService  busRentsService;


    //查询指定的出租单信息
    @RequestMapping("/findOneBusRents")
    @ResponseBody
    public   BusRents  findOneBusRents(String  rentid){

        return   busRentsService.findOne(rentid);

    }


    //出租单信息查询
    @RequestMapping("/findMoreBusRents")
    @ResponseBody
    public Page<BusRents>  findMoreBusRents(int page,int rows,BusRents  busRents){

        return   busRentsService.findMore(page, rows, busRents);
    }


    //添加出租单信息
    @RequestMapping("/saveBusRents")
    @ResponseBody
    public    int   saveBusRents(BusRents busRents){

        return   busRentsService.save(busRents);
    }
}
