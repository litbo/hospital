package com.litbo.hospital.metering.pojo;

import java.io.Serializable;

/**
 * meteringUtilStatus
 * @author 
 */
public class MeteringUtilStatus implements Serializable {
    private Integer id;

    private Integer utilId;

    private String useType;

    private String recordDate;

    private String bmName;

    private String userXm;

    private String description;

    private String cause;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUtilId() {
        return utilId;
    }

    public void setUtilId(Integer utilId) {
        this.utilId = utilId;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getUserXm() {
        return userXm;
    }

    public void setUserXm(String userXm) {
        this.userXm = userXm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
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
        MeteringUtilStatus other = (MeteringUtilStatus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUtilId() == null ? other.getUtilId() == null : this.getUtilId().equals(other.getUtilId()))
            && (this.getUseType() == null ? other.getUseType() == null : this.getUseType().equals(other.getUseType()))
            && (this.getRecordDate() == null ? other.getRecordDate() == null : this.getRecordDate().equals(other.getRecordDate()))
            && (this.getBmName() == null ? other.getBmName() == null : this.getBmName().equals(other.getBmName()))
            && (this.getUserXm() == null ? other.getUserXm() == null : this.getUserXm().equals(other.getUserXm()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCause() == null ? other.getCause() == null : this.getCause().equals(other.getCause()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUtilId() == null) ? 0 : getUtilId().hashCode());
        result = prime * result + ((getUseType() == null) ? 0 : getUseType().hashCode());
        result = prime * result + ((getRecordDate() == null) ? 0 : getRecordDate().hashCode());
        result = prime * result + ((getBmName() == null) ? 0 : getBmName().hashCode());
        result = prime * result + ((getUserXm() == null) ? 0 : getUserXm().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCause() == null) ? 0 : getCause().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", utilId=").append(utilId);
        sb.append(", useType=").append(useType);
        sb.append(", recordDate=").append(recordDate);
        sb.append(", bmName=").append(bmName);
        sb.append(", userXm=").append(userXm);
        sb.append(", description=").append(description);
        sb.append(", cause=").append(cause);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}