package com.github.aricSun.vsbo_oa.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * record
 * @author 
 */
public class Record implements Serializable {
    private Integer recordId;

    private Date recordTime;

    private String recordType;

    private String recordResult;

    private String comment;

    /**
     * 报销单主键
     */
    private Integer eaId;

    /**
     * 员工主键
     */
    private Integer eId;

    private static final long serialVersionUID = 1L;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getRecordResult() {
        return recordResult;
    }

    public void setRecordResult(String recordResult) {
        this.recordResult = recordResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getEaId() {
        return eaId;
    }

    public void setEaId(Integer eaId) {
        this.eaId = eaId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
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
        Record other = (Record) that;
        return (this.getRecordId() == null ? other.getRecordId() == null : this.getRecordId().equals(other.getRecordId()))
            && (this.getRecordTime() == null ? other.getRecordTime() == null : this.getRecordTime().equals(other.getRecordTime()))
            && (this.getRecordType() == null ? other.getRecordType() == null : this.getRecordType().equals(other.getRecordType()))
            && (this.getRecordResult() == null ? other.getRecordResult() == null : this.getRecordResult().equals(other.getRecordResult()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getEaId() == null ? other.getEaId() == null : this.getEaId().equals(other.getEaId()))
            && (this.geteId() == null ? other.geteId() == null : this.geteId().equals(other.geteId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        result = prime * result + ((getRecordType() == null) ? 0 : getRecordType().hashCode());
        result = prime * result + ((getRecordResult() == null) ? 0 : getRecordResult().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getEaId() == null) ? 0 : getEaId().hashCode());
        result = prime * result + ((geteId() == null) ? 0 : geteId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordId=").append(recordId);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", recordType=").append(recordType);
        sb.append(", recordResult=").append(recordResult);
        sb.append(", comment=").append(comment);
        sb.append(", eaId=").append(eaId);
        sb.append(", eId=").append(eId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}