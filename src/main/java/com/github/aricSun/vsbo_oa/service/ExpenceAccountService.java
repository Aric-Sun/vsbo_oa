package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.ExpenceAccountMapper;
import com.github.aricSun.vsbo_oa.pojo.ExpenceAccount;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;


/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Service
public class ExpenceAccountService {

    @Resource
    private ExpenceAccountMapper expenceAccountMapper;

    public void addExpenseAccount(ExpenceAccount expenceAccount) {
        expenceAccountMapper.insert(expenceAccount);
    }

    // 根据编号查询基本信息，需要联查姓名
    public HashMap getExpenseById(int eaId) {
        return expenceAccountMapper.getExpenseById(eaId);
    }
}
