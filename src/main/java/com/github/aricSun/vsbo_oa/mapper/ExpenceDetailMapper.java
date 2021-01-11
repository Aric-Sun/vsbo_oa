package com.github.aricSun.vsbo_oa.mapper;

import com.github.aricSun.vsbo_oa.pojo.ExpenceDetail;

import java.util.List;

public interface ExpenceDetailMapper {
    int deleteByPrimaryKey(Integer edId);

    int insert(ExpenceDetail record);

    int insertSelective(ExpenceDetail record);

    ExpenceDetail selectByPrimaryKey(Integer edId);

    int updateByPrimaryKeySelective(ExpenceDetail record);

    int updateByPrimaryKey(ExpenceDetail record);

    List<ExpenceDetail> selectByEaId(int eaId);
}