package com.github.aricSun.vsbo_oa.mapper;

import com.github.aricSun.vsbo_oa.pojo.ExpenceAccount;

public interface ExpenceAccountMapper {
    int deleteByPrimaryKey(Integer eaId);

    int insert(ExpenceAccount record);

    int insertSelective(ExpenceAccount record);

    ExpenceAccount selectByPrimaryKey(Integer eaId);

    int updateByPrimaryKeySelective(ExpenceAccount record);

    int updateByPrimaryKey(ExpenceAccount record);
}