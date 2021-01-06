package com.github.aricSun.vsbo_oa.mapper;

import com.github.aricSun.vsbo_oa.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /*自定义*/
    // 添加部门
    void addDept(Department dept);
    // 修改部门信息
    void updateDept(Department dept);
    //根据部门编号，查询对应的部门信息
    Department getDeptById(int dId);
    // 删除部门，凭id
    void deleteDept(int dId);
    // 查询所有的部门
    List<Department> getDepts();
}