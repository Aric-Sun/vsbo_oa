package com.github.aricSun.vsbo_oa.pojo;

import java.io.Serializable;

/**
 * department
 * @author 
 */
public class Department implements Serializable {
    private Integer dId;

    private String dname;

    private String address;

    private static final long serialVersionUID = 1L;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        Department other = (Department) that;
        return (this.getdId() == null ? other.getdId() == null : this.getdId().equals(other.getdId()))
            && (this.getDname() == null ? other.getDname() == null : this.getDname().equals(other.getDname()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getdId() == null) ? 0 : getdId().hashCode());
        result = prime * result + ((getDname() == null) ? 0 : getDname().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dId=").append(dId);
        sb.append(", dname=").append(dname);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}