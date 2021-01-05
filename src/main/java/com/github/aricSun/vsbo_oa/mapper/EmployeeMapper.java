package com.github.aricSun.vsbo_oa.mapper;

import com.github.aricSun.vsbo_oa.pojo.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
public interface EmployeeMapper {
    // 根据id查询
    Employee getEmpById(@Param("id") int id);
}
