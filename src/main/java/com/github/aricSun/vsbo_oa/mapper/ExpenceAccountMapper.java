package com.github.aricSun.vsbo_oa.mapper;

import com.github.aricSun.vsbo_oa.pojo.ExpenceAccount;

import java.util.HashMap;
import java.util.List;

public interface ExpenceAccountMapper {
    int deleteByPrimaryKey(Integer eaId);

    int insert(ExpenceAccount record);

    int insertSelective(ExpenceAccount record);

    ExpenceAccount selectByPrimaryKey(Integer eaId);

    int updateByPrimaryKeySelective(ExpenceAccount record);

    int updateByPrimaryKey(ExpenceAccount record);

    // 根据编号查询基本信息，需要联查姓名
    HashMap getExpenseById(int eaId);

    // 联查姓名ename
    List getByCreatorId(Integer eId);

    // 联查ename，待处理报销单
    List getByNextHandlerId(Integer eId);
}