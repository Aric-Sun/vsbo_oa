package com.github.aricSun.vsbo_oa.mapper;

import com.github.aricSun.vsbo_oa.pojo.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}