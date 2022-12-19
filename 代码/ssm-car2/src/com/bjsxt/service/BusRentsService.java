package com.bjsxt.service;

import com.bjsxt.pojo.BusRents;
import com.bjsxt.pojo.Page;

public interface BusRentsService {

    //汽车出租单生成
    public   int   save(BusRents busRents);

    //汽车出租单信息查询
    public Page<BusRents>  findMore(int  page,int rows,BusRents  busRents);

    //汽车出租单订单的查询
    public     BusRents   findOne(String  rentid);


}
