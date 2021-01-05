package com.github.aricSun.vsbo_oa.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * expence_account
 * @author 
 */
public class ExpenceAccount implements Serializable {
    private Integer eaId;

    private String cause;

    private Date createTime;

    private Double totalMoney;

    private String status;

    /**
     * 创建者id
     */
    private Integer createrId;

    /**
     * 下一个处理者
     */
    private Integer nextHandlerId;

    private static final long serialVersionUID = 1L;

    public Integer getEaId() {
        return eaId;
    }

    public void setEaId(Integer eaId) {
        this.eaId = eaId;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public Integer getNextHandlerId() {
        return nextHandlerId;
    }

    public void setNextHandlerId(Integer nextHandlerId) {
        this.nextHandlerId = nextHandlerId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ExpenceAccount other = (ExpenceAccount) that;
        return (this.getEaId() == null ? other.getEaId() == null : this.getEaId().equals(other.getEaId()))
            && (this.getCause() == null ? other.getCause() == null : this.getCause().equals(other.getCause()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTotalMoney() == null ? other.getTotalMoney() == null : this.getTotalMoney().equals(other.getTotalMoney()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreaterId() == null ? other.getCreaterId() == null : this.getCreaterId().equals(other.getCreaterId()))
            && (this.getNextHandlerId() == null ? other.getNextHandlerId() == null : this.getNextHandlerId().equals(other.getNextHandlerId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEaId() == null) ? 0 : getEaId().hashCode());
        result = prime * result + ((getCause() == null) ? 0 : getCause().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTotalMoney() == null) ? 0 : getTotalMoney().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreaterId() == null) ? 0 : getCreaterId().hashCode());
        result = prime * result + ((getNextHandlerId() == null) ? 0 : getNextHandlerId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eaId=").append(eaId);
        sb.append(", cause=").append(cause);
        sb.append(", createTime=").append(createTime);
        sb.append(", totalMoney=").append(totalMoney);
        sb.append(", status=").append(status);
        sb.append(", createrId=").append(createrId);
        sb.append(", nextHandlerId=").append(nextHandlerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}