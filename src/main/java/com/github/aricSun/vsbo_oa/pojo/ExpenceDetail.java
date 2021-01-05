package com.github.aricSun.vsbo_oa.pojo;

import java.io.Serializable;

/**
 * expence_detail
 * @author 
 */
public class ExpenceDetail implements Serializable {
    private Integer edId;

    private String type;

    private Double money;

    private String description;

    /**
     * 报销单主键
     */
    private Integer eaId;

    private static final long serialVersionUID = 1L;

    public Integer getEdId() {
        return edId;
    }

    public void setEdId(Integer edId) {
        this.edId = edId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEaId() {
        return eaId;
    }

    public void setEaId(Integer eaId) {
        this.eaId = eaId;
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
        ExpenceDetail other = (ExpenceDetail) that;
        return (this.getEdId() == null ? other.getEdId() == null : this.getEdId().equals(other.getEdId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getEaId() == null ? other.getEaId() == null : this.getEaId().equals(other.getEaId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEdId() == null) ? 0 : getEdId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getEaId() == null) ? 0 : getEaId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", edId=").append(edId);
        sb.append(", type=").append(type);
        sb.append(", money=").append(money);
        sb.append(", description=").append(description);
        sb.append(", eaId=").append(eaId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}