package com.github.aricSun.vsbo_oa.pojo;

import java.util.List;

/**
 * VO
 * 报销单明细
 * @author AricSun
 * @date 2021.01.10 11:37
 */
public class ExpenseAccountInfo {
    private ExpenceAccount expenceAccount;  // 报销单
    private List<ExpenceDetail> details;  // 报销单明细

    public ExpenseAccountInfo() {
    }

    public ExpenseAccountInfo(ExpenceAccount expenceAccount, List<ExpenceDetail> details) {
        this.expenceAccount = expenceAccount;
        this.details = details;
    }

    public ExpenceAccount getExpenceAccount() {
        return expenceAccount;
    }

    public void setExpenceAccount(ExpenceAccount expenceAccount) {
        this.expenceAccount = expenceAccount;
    }

    public List<ExpenceDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ExpenceDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ExpenseAccountInfo{" +
                "expenceAccount=" + expenceAccount +
                ", details=" + details +
                '}';
    }
}
