package com.github.aricSun.vsbo_oa.controller;

import com.github.aricSun.vsbo_oa.pojo.Department;
import com.github.aricSun.vsbo_oa.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Controller
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/to_deptList.do")
    public String toList(HttpServletRequest request){

        // 查询所有的部门信息
        List<Department> depts = departmentService.getDepts();
//        map.put("depts", depts);
        request.setAttribute("depts", depts);

        return "dept_list";
    }

    @RequestMapping("/to_add.do")
    public String to_add(){
        return "dept_add";
    }

    @RequestMapping("/addDept.do")
    public String addDept(Department dept){
        departmentService.addDept(dept);
        return "redirect:to_deptList.do";  // success
    }

    @RequestMapping("/to_updateDept.do")
    public String to_updateDept(int dId, HashMap map){
        // 查询当前的部门对象，将此对象存储在域中，转发到修改页面
        Department deptById = departmentService.getDeptById(dId);
        map.put("dept", deptById);
        return "dept_update";
    }

    @RequestMapping("/updateDept.do")
    public String updateDept(Department dept){
        departmentService.updateDept(dept);
        return "redirect:to_deptList.do";  // success
    }

    @RequestMapping("/deleteDept.do")
    public String deleteDept(int dId){
        departmentService.deleteDept(dId);
        return "redirect:to_deptList.do";  // success
    }
}
