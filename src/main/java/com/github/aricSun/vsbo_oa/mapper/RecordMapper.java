package com.github.aricSun.vsbo_oa.mapper;

import com.github.aricSun.vsbo_oa.pojo.Record;

import java.util.List;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    // 联查员工姓名
    List selectByEaId(int eaId);
}