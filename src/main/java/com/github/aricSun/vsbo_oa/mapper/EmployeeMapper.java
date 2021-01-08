package com.github.aricSun.vsbo_oa.mapper;

import com.github.aricSun.vsbo_oa.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
public interface EmployeeMapper {
    // 根据id查询
    Employee getEmpById(@Param("id") int id);

    List getEmps();

    // 新增用户信息
    void addEmp(Employee employee);

    // 修改用户信息
    void updateEmp(Employee employee);

    void deleteEmp(@Param("eId") int eId);

    HashMap login(@Param("eId") int eId, @Param("password") String passwordWithMD5);
}

