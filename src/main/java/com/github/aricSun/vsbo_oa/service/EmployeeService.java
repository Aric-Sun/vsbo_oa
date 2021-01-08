package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.EmployeeMapper;
import com.github.aricSun.vsbo_oa.pojo.Employee;
import com.github.aricSun.vsbo_oa.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


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

    public List getEmps() {
        return employeeMapper.getEmps();
    }

    // 新增用户信息
    public void addEmp(Employee employee) {
        // 在业务层处理用户的密码
        // 新增用户时，给出默认的密码，“111111”
        // 采用md5对密码进行加密操作
        String password = MD5Util.md5("111111");
        employee.setPassword(password);
        employeeMapper.addEmp(employee);
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
    }

    public void deleteEmp(int eId) {
        employeeMapper.deleteEmp(eId);
    }

    public HashMap login(int eId, String password) {
        String passwordWithMD5 = MD5Util.md5(password);
        return employeeMapper.login(eId, passwordWithMD5);
    }
}
