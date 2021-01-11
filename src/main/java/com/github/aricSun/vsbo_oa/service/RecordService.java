package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.RecordMapper;
import com.github.aricSun.vsbo_oa.pojo.Record;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Service
public class RecordService {

    @Resource
    private RecordMapper recordMapper;

    // 联查员工姓名
    public List getByEaId(int eaId) {
        return recordMapper.selectByEaId(eaId);
    }
}
