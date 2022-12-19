package com.bjsxt.controller;

import com.bjsxt.pojo.BusCustomers;
import com.bjsxt.service.BusCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/BusCustomersController")
public class BusCustomersController {

    @Autowired
   private   BusCustomersService  busCustomersService;

    //查询指定用户

    @RequestMapping("/findOneBusCustomers")
    @ResponseBody
    public BusCustomers  findOneBusCustomers(String identity){

        return   busCustomersService.findOne(identity);

    }

}
