package com.github.aricSun.vsbo_oa.controller;

import com.github.aricSun.vsbo_oa.pojo.ExpenceAccount;
import com.github.aricSun.vsbo_oa.pojo.ExpenceDetail;
import com.github.aricSun.vsbo_oa.pojo.ExpenseAccountInfo;
import com.github.aricSun.vsbo_oa.service.ExpenceAccountService;
import com.github.aricSun.vsbo_oa.service.ExpenceDetailService;
import com.github.aricSun.vsbo_oa.service.RecordService;
import com.github.aricSun.vsbo_oa.utils.Constant;
import com.github.aricSun.vsbo_oa.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
public class ExpenceAccountController {
    @Resource
    private ExpenceAccountService expenceAccountService;
    @Resource
    private ExpenceDetailService expenceDetailService;
    @Resource
    private RecordService recordService;

    // 去填写报销单
    @RequestMapping("/to_addExpence.do")
    public String to_addExpence(HttpServletRequest request){
        request.setAttribute("items", Constant.getItems());
        return "expence_account_add";
    }

    // 保存报销单
    // 不是提交，仅仅是保存到DB
    @RequestMapping("/addExpence.do")
    @Transactional
    public String addExpence(ExpenseAccountInfo info, HttpSession session){
        // 获取当前用户id
        Integer eId = SessionUtils.getEId(session);

        // 获取报销单对象，并设定一些值
        ExpenceAccount expenceAccount = info.getExpenceAccount();

        // 新增完成后，返回一个主键id，留给明细表的外键
        expenceAccountService.addExpenseAccount(expenceAccount,eId);
        int eaId = expenceAccount.getEaId();

        // 设定报销单id为外键
        List<ExpenceDetail> details = info.getDetails();
        for (ExpenceDetail detail : details) {
            expenceDetailService.addExpenseDetail(detail, eaId);
        }

        // 跳转到报销单明细
        return "redirect:getExpenceDetail.do?eaId="+eaId;
    }

    // 获取报销单明细
    @RequestMapping("/getExpenceDetail.do")
    public String getExpenseDetail(int eaId, HashMap map){

        // 联查createrName和nextName
        map.put("expenceAccountMap", expenceAccountService.getExpenseById(eaId));

        map.put("expenceDetails", expenceDetailService.getDetailsByEaId(eaId));

        // 联查员工姓名
        map.put("records", recordService.getByEaId(eaId));

        return "expence_account_detail";
    }

    // 查看个人报销单，当前登录用户的
    @RequestMapping("/getExpenceAccountForSelf.do")
    public String getExpenceAccountForSelf(HttpSession session, HashMap hashMap){
        // 获取当前用户id
        Integer eId = SessionUtils.getEId(session);
        List eas = expenceAccountService.getByCreatorId(eId);
        hashMap.put("eas", eas);
        return "expence_account_self";
    }

    // 获取待处理报销单，当前登录用户的
    @RequestMapping("/getExpenceAccountForNext.do")
    public String getExpenceAccountForNext(HttpSession session, HashMap hashMap){
        // 获取当前用户id
        Integer eId = SessionUtils.getEId(session);
        List eas = expenceAccountService.getByNextHandlerId(eId);
        hashMap.put("eas", eas);

        return "expence_account_deal";
    }

    /*
     * function: 提交报销单
     * @Param [eaId报销单编号]
     * @Return java.lang.String
     */
    @RequestMapping("/submit.do")
    public String submit(int eaId){
        expenceAccountService.submit(eaId);
        return "redirect:getExpenceAccountForNext.do";  // 处理完成之后回到待处理报销单
    }
}