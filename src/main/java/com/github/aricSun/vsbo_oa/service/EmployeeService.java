package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.EmployeeMapper;
import com.github.aricSun.vsbo_oa.pojo.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    public Employee getEmpById(int id) {
        return employeeMapper.getEmpById(id);
    }
}
