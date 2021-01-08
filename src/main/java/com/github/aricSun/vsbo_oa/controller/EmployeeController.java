package com.github.aricSun.vsbo_oa.controller;

import com.github.aricSun.vsbo_oa.pojo.Department;
import com.github.aricSun.vsbo_oa.pojo.Employee;
import com.github.aricSun.vsbo_oa.service.DepartmentService;
import com.github.aricSun.vsbo_oa.service.EmployeeService;
import com.github.aricSun.vsbo_oa.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/getEmpById.do")
    public String getEmpById(int id, HashMap map){
        Employee emp = employeeService.getEmpById(id);
        map.put("emp",emp);
        return "forward:index.jsp";
    }

    @RequestMapping("/getEmps.do")
    public String getEmps(HashMap map){
        List emps = employeeService.getEmps();
        map.put("emps", emps);
        return "emp_list";
    }

    @RequestMapping("/to_addEmp.do")
    public String to_addEmp(HashMap map){

        // 添加页面需要显示部门信息，调用部门的查询所有的方法
        List<Department> depts = departmentService.getDepts();  // 查询所有部门信息

        // 添加真面需要显示职位信息
        List<String> jobs = Constant.getPost();  // 查询所有职位信息

        map.put("depts", depts);
        map.put("jobs", jobs);

        return "emp_add";
    }

    // 新增用户信息
    @RequestMapping("/addEmp.do")
    public String addEmp(Employee employee){

        employeeService.addEmp(employee);

        return "redirect:getEmps.do";  // 重定向到列表页，不能保留上次的地址栏，不然会重复发请求
    }

    @RequestMapping("/to_updateEmp.do")
    public String to_updateEmp(int eId, HashMap map){

        // 员工信息回写
        Employee empById = employeeService.getEmpById(eId);

        // 所有的部门信息
        List<Department> depts = departmentService.getDepts();

        // 所有的职位信息
        List<String> jobs = Constant.getPost();

        map.put("emp", empById);
        map.put("depts", depts);
        map.put("jobs", jobs);

        return "emp_update";
    }

    @RequestMapping("/updateEmp.do")
    public String updateEmp(Employee employee){

        employeeService.updateEmp(employee);

        return "redirect:getEmps.do";
    }

    @RequestMapping("/deleteEmp.do")
    public String deleteEmp(int eId){

        employeeService.deleteEmp(eId);

        return "redirect:getEmps.do";
    }

    // 登录
    @RequestMapping("/login.do")
    public String login(int eId, String password, HttpServletRequest request, HttpSession session){
        // 如果登陆成功，到个人中心
        // 登陆失败，回到登录界面，给出错误信息

        // 数据库中的密码是加密，验证时先加密
        HashMap hashMap = employeeService.login(eId, password);
        if (hashMap != null){
            // login ok
            // 将用户信息存储在session
            session.setAttribute("map", hashMap);  // 只需要有值就行，存什么不重要
            return "self";
        } else {
            // fail
            request.setAttribute("loginError", "用户名或者密码输入有误");
            return "forward:login.jsp";  // 不在views下，不能走视图解析器
        }
    }

    // 个人中心
    @RequestMapping("/self.do")
    public String self(HttpSession session,HttpServletRequest request){
//        employeeService.getEmpById(session.getAttribute("map")
        HashMap map = (HashMap) session.getAttribute("map");
        int eId = (int) map.get("eId");
        Employee empById = employeeService.getEmpById(eId);
        request.setAttribute("emp" ,empById);
        return "self";
    }
}
