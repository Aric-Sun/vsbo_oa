package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

}
