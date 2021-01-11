package com.github.aricSun.vsbo_oa.controller;

import com.github.aricSun.vsbo_oa.mapper.RecordMapper;
import com.github.aricSun.vsbo_oa.service.RecordService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Controller
public class RecordController {
    @Resource
    private RecordService recordService;
}
