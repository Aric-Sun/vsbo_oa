package com.github.aricSun.vsbo_oa.controller;

import com.github.aricSun.vsbo_oa.service.DepartmentService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Controller
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;
}
