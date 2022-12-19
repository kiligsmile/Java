package com.bjsxt.controller;

import com.bjsxt.pojo.BusChecks;
import com.bjsxt.service.BusChecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/busChecksController")
public class BusChecksController {

    @Autowired
    private BusChecksService  busChecksService;

    @RequestMapping("/saveBusChecks")
    @ResponseBody
    public    int  saveBusChecks(BusChecks  busChecks,String carnumber){

        return   busChecksService.save(busChecks,carnumber);
    }
}
