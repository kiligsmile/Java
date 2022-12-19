package com.bjsxt.service.impl;

import com.bjsxt.mapper.AccountMapper;
import com.bjsxt.pojo.Account;
import com.bjsxt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accounts")
public class AccountServiceImpl  implements AccountService {

      @Autowired
      AccountMapper  accountMapper;

    @Override
    public Account findOne(String cno, String pwd, String money) {
        return accountMapper.selectOne(cno, pwd, money);
    }

    @Override
    @Transactional
    public int change(String outcno, String incno, int money) {

        //汇款人余额减少
        int update = accountMapper.update(outcno, money);
        //收款人余额增加
        int update2 = accountMapper.update2(incno, money);

        if(update>0&&update2>0){
            return 1;
        }


        return 0;
    }
}
