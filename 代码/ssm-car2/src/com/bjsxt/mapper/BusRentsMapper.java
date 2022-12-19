package com.bjsxt.mapper;

import com.bjsxt.pojo.BusRents;

import java.util.List;

public interface BusRentsMapper {

    //汽车的出租单产生
    public   int   insert(BusRents  busRents);

    //汽车出租单查询的操作
    public List<BusRents>  selectMore(BusRents busRents);

    //汽车出租单信息的查询
    public   BusRents   selectOne(String  rentid);

    //修改出租单状态
    public    int  update(String  rentid);


}
