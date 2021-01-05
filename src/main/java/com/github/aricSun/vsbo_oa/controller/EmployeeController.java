package com.github.aricSun.vsbo_oa.controller;

import com.github.aricSun.vsbo_oa.pojo.Employee;
import com.github.aricSun.vsbo_oa.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/getEmpById.do")
    public String getEmpById(int id, HashMap map){
        Employee emp = employeeService.getEmpById(id);
        map.put("emp",emp);
        return "forward:index.jsp";
    }
}
