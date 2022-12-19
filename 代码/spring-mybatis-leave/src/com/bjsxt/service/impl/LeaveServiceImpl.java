package com.bjsxt.service.impl;

import com.bjsxt.mapper.LeaveMapper;
import com.bjsxt.pojo.Leave;
import com.bjsxt.service.LeaveService;

import java.util.List;

public class LeaveServiceImpl  implements LeaveService {

    LeaveMapper  leaveMapper;


    @Override
    public List<Leave> findAll() {
        return leaveMapper.selectAll();
    }

    @Override
    public int remove(int id) {
        return leaveMapper.delete(id);
    }


    public LeaveMapper getLeaveMapper() {
        return leaveMapper;
    }

    public void setLeaveMapper(LeaveMapper leaveMapper) {
        this.leaveMapper = leaveMapper;
    }
}
