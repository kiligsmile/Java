package com.bjsxt.controller;

import com.bjsxt.service.RmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/RmCont")
public class RmCont {


    @Autowired
    RmService  rmService;

    @RequestMapping("rmFindMore")
    @ResponseBody
    public List<Integer>  rmFindMore(int rid){

        return   rmService.findMore(rid);

    }


}
