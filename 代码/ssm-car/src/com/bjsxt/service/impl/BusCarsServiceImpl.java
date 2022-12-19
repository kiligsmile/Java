package com.bjsxt.service.impl;

import com.bjsxt.mapper.BusCarsMapper;
import com.bjsxt.pojo.BusCars;
import com.bjsxt.pojo.Page;
import com.bjsxt.service.BusCarsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusCarsServiceImpl implements BusCarsService {


      @Autowired
     BusCarsMapper  busCarsMapper;

    @Override
    public Page<BusCars> findAll(int page, int rows) {

        com.github.pagehelper.Page page1 = PageHelper.startPage(page, rows);

        List<BusCars> list = busCarsMapper.selectAll();

        Page<BusCars>  pg=new Page<>(list,page1.getTotal());

        return pg;
    }

    @Override
    public Map<String, String> save(BusCars busCars) {

        Map<String, String>  map =new HashMap<>();
        try {
            busCarsMapper.insert(busCars);
        } catch (Exception e) {

            map.put("errorMsg","添加失败");
        }
        return map;
    }

    @Override
    public Map<String, String> remove(String carnumber) {

        Map<String, String>  map =new HashMap<>();

        try {
            busCarsMapper.delete(carnumber);

            map.put("success","删除成功");
        } catch (Exception e) {

            map.put("errorMsg","删除成功");

        }

        return map;
    }

    @Override
    public Map<String, String> change(BusCars busCars) {

        Map<String,String>  map =new HashMap<>();
        try {
            int update = busCarsMapper.update(busCars);
        } catch (Exception e) {

            map.put("errorMsg","修改失败");

        }

        return map;
    }

    @Override
    public Page<BusCars> findMore(int page,int rows) {

        com.github.pagehelper.Page page1 = PageHelper.startPage(page, rows);

        List<BusCars> list = busCarsMapper.selectMore();

        Page<BusCars> pg=new Page<>(list,page1.getTotal());


        return pg;
    }

    @Override
    public BusCars findOne(String carnumber) {
        return busCarsMapper.selectOne(carnumber);
    }

    @Override
    public List eaCount() {

        List<BusCars> list = busCarsMapper.eaCount();


        //保存汽车的数量
        List<Double>   list1=new ArrayList<>();

        //保存车辆的名称
        List<String>  list2=new ArrayList<>();

        for (BusCars  bc:list) {


            list1.add(bc.getPrice());

            list2.add(bc.getCartype());

        }

        List  li=new ArrayList();
        li.add(list1);
        li.add(list2);


        return li;
    }
}
