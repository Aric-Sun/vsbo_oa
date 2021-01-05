package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.RecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Service
public class RecordService {

    @Resource
    private RecordMapper recordMapper;

}
