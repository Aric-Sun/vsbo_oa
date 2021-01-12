package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.EmployeeMapper;
import com.github.aricSun.vsbo_oa.mapper.ExpenceAccountMapper;
import com.github.aricSun.vsbo_oa.mapper.RecordMapper;
import com.github.aricSun.vsbo_oa.pojo.Employee;
import com.github.aricSun.vsbo_oa.pojo.ExpenceAccount;
import com.github.aricSun.vsbo_oa.pojo.Record;
import com.github.aricSun.vsbo_oa.utils.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private RecordMapper recordMapper;

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

    /*
     * function: 提交报销单
     * 修改状态，修改待处理人
     * @Param [eaId]
     * @Return void
     */
    @Transactional
    public void submit(int eaId) {
        // 获取一个简单的报销单对象
        ExpenceAccount ea = expenceAccountMapper.selectByPrimaryKey(eaId);
        // 获取创建者对象
        Employee empCreator = employeeMapper.getEmpById(ea.getCreaterId());
        // 获取其同部门的部门经理
        Employee empPM = employeeMapper.selectByDeptAndJob(empCreator.getdId(), Constant.POST_PM);

        // 设置状态已提交
        ea.setStatus(Constant.EXPENCE_SUBMIT);
        // 设置下一个处理人为部门经理
        ea.setNextHandlerId(empPM.geteId());

        // 持久层更新
        expenceAccountMapper.updateByPrimaryKey(ea);

        // 操作记录
        Record record = new Record();
        record.setRecordTime(new Date());
        record.setRecordType(Constant.DEAL_SUBMIT);
        record.setRecordResult(Constant.EXPENCE_SUBMIT);
        record.setComment("无");
        record.setEaId(eaId);
        record.seteId(empCreator.geteId());  // 创建者本人

        // 持久层新增
        recordMapper.insertSelective(record);  // 可能comment为空，所以要用Selective
    }
}
