package com.github.aricSun.vsbo_oa.controller;

import com.github.aricSun.vsbo_oa.mapper.ExpenceAccountMapper;
import com.github.aricSun.vsbo_oa.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author AricSun
 * @date 2021.01.05 11:53
 */
@Controller
public class ExpenceAccountController {
    @Resource
    private ExpenceAccountMapper expenceAccountMapper;

    // 去填写报销单
    @RequestMapping("/to_addExpence.do")
    public String to_addExpence(HttpServletRequest request){
        request.setAttribute("items", Constant.getItems());
        return "expence_account_add";
    }
}