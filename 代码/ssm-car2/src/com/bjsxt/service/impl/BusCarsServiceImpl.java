package com.bjsxt.service.impl;

import com.bjsxt.mapper.BusCarsMapper;
import com.bjsxt.pojo.BusCars;
import com.bjsxt.pojo.Page;
import com.bjsxt.service.BusCarsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusCarsServiceImpl  implements BusCarsService {

    @Autowired
    private BusCarsMapper  busCarsMapper;

    @Override
    public Page<BusCars> findAll(int page, int rows) {

        com.github.pagehelper.Page pg = PageHelper.startPage(page, rows);

        List<BusCars> list = busCarsMapper.selectAll();

        Page<BusCars>  page1=new Page<>(list,pg.getTotal());

        return page1;
    }

    @Override
    public int save(BusCars busCars) {
        return busCarsMapper.insert(busCars);
    }

    @Override
    public int change(BusCars busCars) {

        return busCarsMapper.update(busCars);
    }

    @Override
    public int remove(String carnumber) {
        return busCarsMapper.delete(carnumber);
    }

    @Override
    public Page<BusCars> findMore(int page, int rows) {

        com.github.pagehelper.Page page1 = PageHelper.startPage(page, rows);

        List<BusCars> list = busCarsMapper.selectMore();

        Page<BusCars>  pg =new Page<>(list,page1.getTotal());

        return pg;
    }

    @Override
    public BusCars findOne(String carnumber) {
        return busCarsMapper.selectOne(carnumber);
    }
}
