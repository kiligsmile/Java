package com.bjsxt.controller;

import com.bjsxt.pojo.BusCustomers;
import com.bjsxt.service.BusCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/BusCustomersCont")
public class BusCustomersCont {


    @Autowired
    BusCustomersService  busCustomersService;


    @RequestMapping("customersFindOne")
    @ResponseBody
    public BusCustomers customersFindOne(String  identity){

        return  busCustomersService.findOne(identity);


    }

}
