package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.ExpenceAccountMapper;
import com.github.aricSun.vsbo_oa.pojo.ExpenceAccount;
import com.github.aricSun.vsbo_oa.utils.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Service
public class ExpenceAccountService {

    @Resource
    private ExpenceAccountMapper expenceAccountMapper;

    public void addExpenseAccount(ExpenceAccount expenceAccount, Integer eId) {
        expenceAccount.setCreateTime(new Date());  // set time as current time
        expenceAccount.setStatus(Constant.EXPENCE_CREATED);  // 设置报销单状态：新创建
        expenceAccount.setCreaterId(eId);
        expenceAccount.setNextHandlerId(eId);
        expenceAccountMapper.insert(expenceAccount);
    }

    // 根据编号查询基本信息，需要联查姓名
    public HashMap getExpenseById(int eaId) {
        return expenceAccountMapper.getExpenseById(eaId);
    }

    // 联查ename
    public List getByCreatorId(Integer eId) {
        return expenceAccountMapper.getByCreatorId(eId);
    }

    // 联查ename，查询带出差报销单
    public List getByNextHandlerId(Integer eId) {
        return expenceAccountMapper.getByNextHandlerId(eId);
    }
}
