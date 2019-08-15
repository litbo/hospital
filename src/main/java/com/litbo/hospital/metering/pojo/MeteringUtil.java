package com.litbo.hospital.metering.pojo;

import java.io.Serializable;

/**
 * metering_util
 * @author 
 */
public class MeteringUtil implements Serializable {
    private Integer id;

    private String meteringName;

    private String meteringNum;

    private String meteringInspectionCycle;

    private String bmname;

    private String buyTime;

    private String userxm;

    private String updateMessageTime;

    private String thisMeteringTime;

    private String utilType;

    private String description;

    private String meteringstatus;

    private String meteringSystemNum;

    private String meteringGetNumberTime;

    private String recordPerson;

    private String recordTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeteringName() {
        return meteringName;
    }

    public void setMeteringName(String meteringName) {
        this.meteringName = meteringName;
    }

    public String getMeteringNum() {
        return meteringNum;
    }

    public void setMeteringNum(String meteringNum) {
        this.meteringNum = meteringNum;
    }

    public String getMeteringInspectionCycle() {
        return meteringInspectionCycle;
    }

    public void setMeteringInspectionCycle(String meteringInspectionCycle) {
        this.meteringInspectionCycle = meteringInspectionCycle;
    }

    public String getBmname() {
        return bmname;
    }

    public void setBmname(String bmname) {
        this.bmname = bmname;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getUserxm() {
        return userxm;
    }

    public void setUserxm(String userxm) {
        this.userxm = userxm;
    }

    public String getUpdateMessageTime() {
        return updateMessageTime;
    }

    public void setUpdateMessageTime(String updateMessageTime) {
        this.updateMessageTime = updateMessageTime;
    }

    public String getThisMeteringTime() {
        return thisMeteringTime;
    }

    public void setThisMeteringTime(String thisMeteringTime) {
        this.thisMeteringTime = thisMeteringTime;
    }

    public String getUtilType() {
        return utilType;
    }

    public void setUtilType(String utilType) {
        this.utilType = utilType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeteringstatus() {
        return meteringstatus;
    }

    public void setMeteringstatus(String meteringstatus) {
        this.meteringstatus = meteringstatus;
    }

    public String getMeteringSystemNum() {
        return meteringSystemNum;
    }

    public void setMeteringSystemNum(String meteringSystemNum) {
        this.meteringSystemNum = meteringSystemNum;
    }

    public String getMeteringGetNumberTime() {
        return meteringGetNumberTime;
    }

    public void setMeteringGetNumberTime(String meteringGetNumberTime) {
        this.meteringGetNumberTime = meteringGetNumberTime;
    }

    public String getRecordPerson() {
        return recordPerson;
    }

    public void setRecordPerson(String recordPerson) {
        this.recordPerson = recordPerson;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
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
        MeteringUtil other = (MeteringUtil) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMeteringName() == null ? other.getMeteringName() == null : this.getMeteringName().equals(other.getMeteringName()))
            && (this.getMeteringNum() == null ? other.getMeteringNum() == null : this.getMeteringNum().equals(other.getMeteringNum()))
            && (this.getMeteringInspectionCycle() == null ? other.getMeteringInspectionCycle() == null : this.getMeteringInspectionCycle().equals(other.getMeteringInspectionCycle()))
            && (this.getBmname() == null ? other.getBmname() == null : this.getBmname().equals(other.getBmname()))
            && (this.getBuyTime() == null ? other.getBuyTime() == null : this.getBuyTime().equals(other.getBuyTime()))
            && (this.getUserxm() == null ? other.getUserxm() == null : this.getUserxm().equals(other.getUserxm()))
            && (this.getUpdateMessageTime() == null ? other.getUpdateMessageTime() == null : this.getUpdateMessageTime().equals(other.getUpdateMessageTime()))
            && (this.getThisMeteringTime() == null ? other.getThisMeteringTime() == null : this.getThisMeteringTime().equals(other.getThisMeteringTime()))
            && (this.getUtilType() == null ? other.getUtilType() == null : this.getUtilType().equals(other.getUtilType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMeteringstatus() == null ? other.getMeteringstatus() == null : this.getMeteringstatus().equals(other.getMeteringstatus()))
            && (this.getMeteringSystemNum() == null ? other.getMeteringSystemNum() == null : this.getMeteringSystemNum().equals(other.getMeteringSystemNum()))
            && (this.getMeteringGetNumberTime() == null ? other.getMeteringGetNumberTime() == null : this.getMeteringGetNumberTime().equals(other.getMeteringGetNumberTime()))
            && (this.getRecordPerson() == null ? other.getRecordPerson() == null : this.getRecordPerson().equals(other.getRecordPerson()))
            && (this.getRecordTime() == null ? other.getRecordTime() == null : this.getRecordTime().equals(other.getRecordTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMeteringName() == null) ? 0 : getMeteringName().hashCode());
        result = prime * result + ((getMeteringNum() == null) ? 0 : getMeteringNum().hashCode());
        result = prime * result + ((getMeteringInspectionCycle() == null) ? 0 : getMeteringInspectionCycle().hashCode());
        result = prime * result + ((getBmname() == null) ? 0 : getBmname().hashCode());
        result = prime * result + ((getBuyTime() == null) ? 0 : getBuyTime().hashCode());
        result = prime * result + ((getUserxm() == null) ? 0 : getUserxm().hashCode());
        result = prime * result + ((getUpdateMessageTime() == null) ? 0 : getUpdateMessageTime().hashCode());
        result = prime * result + ((getThisMeteringTime() == null) ? 0 : getThisMeteringTime().hashCode());
        result = prime * result + ((getUtilType() == null) ? 0 : getUtilType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMeteringstatus() == null) ? 0 : getMeteringstatus().hashCode());
        result = prime * result + ((getMeteringSystemNum() == null) ? 0 : getMeteringSystemNum().hashCode());
        result = prime * result + ((getMeteringGetNumberTime() == null) ? 0 : getMeteringGetNumberTime().hashCode());
        result = prime * result + ((getRecordPerson() == null) ? 0 : getRecordPerson().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", meteringName=").append(meteringName);
        sb.append(", meteringNum=").append(meteringNum);
        sb.append(", meteringInspectionCycle=").append(meteringInspectionCycle);
        sb.append(", bmname=").append(bmname);
        sb.append(", buyTime=").append(buyTime);
        sb.append(", userxm=").append(userxm);
        sb.append(", updateMessageTime=").append(updateMessageTime);
        sb.append(", thisMeteringTime=").append(thisMeteringTime);
        sb.append(", utilType=").append(utilType);
        sb.append(", description=").append(description);
        sb.append(", meteringstatus=").append(meteringstatus);
        sb.append(", meteringSystemNum=").append(meteringSystemNum);
        sb.append(", meteringGetNumberTime=").append(meteringGetNumberTime);
        sb.append(", recordPerson=").append(recordPerson);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}