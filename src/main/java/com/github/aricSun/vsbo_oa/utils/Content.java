package com.github.aricSun.vsbo_oa.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AricSun
 * @date 2021.01.05 11:54
 */
public class Content {
    //    职务相关信息
    public static final String POST_STAFF = "员工";
    public static final String POST_PM = "部门经理";
    public static final String POST_GM = "总经理";
    public static final String POST_FINANCE= "财务";

    //    提供一个获取所有职务的方法，返回所有的职务
    public static List<String> getPost(){
        List<String> list = new ArrayList<>();
        list.add(POST_FINANCE);
        list.add(POST_PM);
        list.add(POST_GM);
        list.add(POST_FINANCE);
        return list;
    }

    //    提供一个方法，返回所有的报销类型
    public static List<String> getItems(){
        List<String> list = new ArrayList<>();
        list.add("餐饮");
        list.add("住宿");
        list.add("办公");
        list.add("交通");
        return list;
    }

    //    定义报销单状态
    public static final String EXPENCE_CREATED= "新创建";
    public static final String EXPENCE_SUBMIT= "已提交";
    public static final String EXPENCE_REVIEWED= "已审核";
    public static final String EXPENCE_RECHECK= "待复审";
    public static final String EXPENCE_BACK= "已打回";
    public static final String EXPENCE_END= "已终止";
    public static final String EXPENCE_PAID= "已打款";

    //    审核合度设置
    public static final double LIMIT_CHECK= 5000.00;

    //    处理方式
    public static final String DEAL_CREATE= "创建";
    public static final String DEAL_SUBMIT= "提交";
    public static final String DEAL_UPDATE= "修改";
    public static final String DEAL_BACK= "打回";
    public static final String DEAL_REJECT= "拒绝";
    public static final String DEAL_PASS= "通过";
    public static final String DEAL_PAID= "打款";
}
