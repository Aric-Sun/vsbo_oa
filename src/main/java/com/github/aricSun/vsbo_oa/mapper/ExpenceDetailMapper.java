package com.github.aricSun.vsbo_oa.mapper;

import com.github.aricSun.vsbo_oa.pojo.ExpenceDetail;

public interface ExpenceDetailMapper {
    int deleteByPrimaryKey(Integer edId);

    int insert(ExpenceDetail record);

    int insertSelective(ExpenceDetail record);

    ExpenceDetail selectByPrimaryKey(Integer edId);

    int updateByPrimaryKeySelective(ExpenceDetail record);

    int updateByPrimaryKey(ExpenceDetail record);
}