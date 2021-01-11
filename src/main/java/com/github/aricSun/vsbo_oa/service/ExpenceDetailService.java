package com.github.aricSun.vsbo_oa.service;

import com.github.aricSun.vsbo_oa.mapper.ExpenceDetailMapper;
import com.github.aricSun.vsbo_oa.pojo.ExpenceDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Service
public class ExpenceDetailService {

    @Resource
    private ExpenceDetailMapper expenceDetailMapper;

    public void addExpenseDetail(ExpenceDetail detail) {
        expenceDetailMapper.insert(detail);
    }

    public List<ExpenceDetail> getDetailsByEaId(int eaId) {
        return expenceDetailMapper.selectByEaId(eaId);
    }
}
