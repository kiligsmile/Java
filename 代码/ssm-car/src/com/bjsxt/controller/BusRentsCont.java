package com.bjsxt.controller;

import com.bjsxt.pojo.BusRents;
import com.bjsxt.pojo.Page;
import com.bjsxt.service.BusRentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/BusRentsCont")
public class BusRentsCont {

    @Autowired
    BusRentsService  busRentsService;


    @RequestMapping("BusRentsFindOne")
    @ResponseBody
    public BusRents  BusRentsFindOne(String  rentid) {


         return  busRentsService.findOne(rentid);
    }

        @RequestMapping("BusRentsFindMore")
    @ResponseBody
    public Page<BusRents>  BusRentsFindMore(BusRents  busRents){


        Page<BusRents> pg = busRentsService.findMore(busRents);

        return   pg;
    }



    @InitBinder
    protected void initBinder(WebDataBinder binder) {

        System.out.println("-----initBinder--------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }



    @RequestMapping("BusRentsSave")
    @ResponseBody
    public Map<String,String>  BusRentsSave(BusRents busRents){


          return  busRentsService.save(busRents);

    }


}
