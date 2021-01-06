package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.DepartmentMapper;
import com.github.aricSun.vsbo_oa.pojo.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    public void addDept(Department dept){
        departmentMapper.addDept(dept);
    }

    public void updateDept(Department dept){
        departmentMapper.updateDept(dept);
    }

    public void deleteDept(int dId){
        departmentMapper.deleteDept(dId);
    }

    public Department getDeptById(int dId){
        Department deptById = departmentMapper.getDeptById(dId);
        return deptById;
    }

    public List<Department> getDepts(){
        return departmentMapper.getDepts();
    }

}
