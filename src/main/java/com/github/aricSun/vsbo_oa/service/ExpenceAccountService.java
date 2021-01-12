package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.EmployeeMapper;
import com.github.aricSun.vsbo_oa.mapper.ExpenceAccountMapper;
import com.github.aricSun.vsbo_oa.mapper.RecordMapper;
import com.github.aricSun.vsbo_oa.pojo.Employee;
import com.github.aricSun.vsbo_oa.pojo.ExpenceAccount;
import com.github.aricSun.vsbo_oa.pojo.Record;
import com.github.aricSun.vsbo_oa.utils.Constant;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
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

    // 报销单的审批流程
    @Transactional
    public void check(int eaId, String dealWay, HashMap map) {
        ExpenceAccount ea = expenceAccountMapper.selectByPrimaryKey(eaId);

        Record record = new Record();
        record.setRecordTime(new Date());
        record.seteId((Integer) (map.get("eId")));
        record.setEaId(eaId);
        record.setRecordType(dealWay);

        switch (dealWay){
            case Constant.DEAL_PASS: // 通过的处理方式，金额小于5000，当前处理人是总经理，处理后的状态为已审核，下一个处理人是财务
                if (ea.getTotalMoney() < 5000 || map.get("job").equals(Constant.POST_GM)){
                    ea.setStatus(Constant.EXPENCE_REVIEWED);  // 已审核
                    ea.setNextHandlerId(employeeMapper.selectByJob(Constant.POST_FINANCE).geteId());  // 交给财务
                    record.setRecordResult(Constant.EXPENCE_REVIEWED);  // 同步记录
                } else {
                    ea.setStatus(Constant.EXPENCE_RECHECK);  // 待复审
                    ea.setNextHandlerId(employeeMapper.selectByJob(Constant.POST_GM).geteId());  // 交给总经理
                    record.setRecordResult(Constant.EXPENCE_RECHECK);  // 同步记录
                }
                break;
            case Constant.DEAL_BACK: // 被打回的处理方式，
                ea.setStatus(Constant.EXPENCE_BACK);  // 被打回
                ea.setNextHandlerId(ea.getCreaterId());  // 交给自己
                record.setRecordResult(Constant.EXPENCE_BACK);  // 同步记录
                break;
            case Constant.DEAL_REJECT: // 被拒绝的处理方式
                ea.setStatus(Constant.EXPENCE_END);  // 终止
                ea.setNextHandlerId(0);  // 终止操作
                record.setRecordResult(Constant.EXPENCE_END);
                break;
            case Constant.DEAL_PAID:
                ea.setStatus(Constant.EXPENCE_PAID);  // 已打款
                ea.setNextHandlerId(0);  // 终止操作
                record.setRecordResult(Constant.EXPENCE_PAID);
                break;
            default:
                break;
        }

        expenceAccountMapper.updateByPrimaryKey(ea);
        recordMapper.insertSelective(record);
    }
}
