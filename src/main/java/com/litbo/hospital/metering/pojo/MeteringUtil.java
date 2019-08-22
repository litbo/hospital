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

    private String bmName;

    private String buyTime;

    private String userXm;

    private String updateMessageTime;

    private String thisMeteringTime;

    private String utilType;

    private String description;

    private String meteringstatus;

    private String meteringSystemNum;

    private String meteringGetNumberTime;

    private String recordPerson;

    private String recordTime;

    private Integer isCycle;

    private String buyPrice;

    private String specificationModle;

    private String serialNumber;

    private String manufacturer;

    private String measuringRange;

    private String accuracyLevel;

    private String legalCategory;

    private String gaugeCategory;

    private Integer sign;

    private String description1;

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

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getUserXm() {
        return userXm;
    }

    public void setUserXm(String userXm) {
        this.userXm = userXm;
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

    public Integer getIsCycle() {
        return isCycle;
    }

    public void setIsCycle(Integer isCycle) {
        this.isCycle = isCycle;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSpecificationModle() {
        return specificationModle;
    }

    public void setSpecificationModle(String specificationModle) {
        this.specificationModle = specificationModle;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMeasuringRange() {
        return measuringRange;
    }

    public void setMeasuringRange(String measuringRange) {
        this.measuringRange = measuringRange;
    }

    public String getAccuracyLevel() {
        return accuracyLevel;
    }

    public void setAccuracyLevel(String accuracyLevel) {
        this.accuracyLevel = accuracyLevel;
    }

    public String getLegalCategory() {
        return legalCategory;
    }

    public void setLegalCategory(String legalCategory) {
        this.legalCategory = legalCategory;
    }

    public String getGaugeCategory() {
        return gaugeCategory;
    }

    public void setGaugeCategory(String gaugeCategory) {
        this.gaugeCategory = gaugeCategory;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
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
            && (this.getBmName() == null ? other.getBmName() == null : this.getBmName().equals(other.getBmName()))
            && (this.getBuyTime() == null ? other.getBuyTime() == null : this.getBuyTime().equals(other.getBuyTime()))
            && (this.getUserXm() == null ? other.getUserXm() == null : this.getUserXm().equals(other.getUserXm()))
            && (this.getUpdateMessageTime() == null ? other.getUpdateMessageTime() == null : this.getUpdateMessageTime().equals(other.getUpdateMessageTime()))
            && (this.getThisMeteringTime() == null ? other.getThisMeteringTime() == null : this.getThisMeteringTime().equals(other.getThisMeteringTime()))
            && (this.getUtilType() == null ? other.getUtilType() == null : this.getUtilType().equals(other.getUtilType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMeteringstatus() == null ? other.getMeteringstatus() == null : this.getMeteringstatus().equals(other.getMeteringstatus()))
            && (this.getMeteringSystemNum() == null ? other.getMeteringSystemNum() == null : this.getMeteringSystemNum().equals(other.getMeteringSystemNum()))
            && (this.getMeteringGetNumberTime() == null ? other.getMeteringGetNumberTime() == null : this.getMeteringGetNumberTime().equals(other.getMeteringGetNumberTime()))
            && (this.getRecordPerson() == null ? other.getRecordPerson() == null : this.getRecordPerson().equals(other.getRecordPerson()))
            && (this.getRecordTime() == null ? other.getRecordTime() == null : this.getRecordTime().equals(other.getRecordTime()))
            && (this.getIsCycle() == null ? other.getIsCycle() == null : this.getIsCycle().equals(other.getIsCycle()))
            && (this.getBuyPrice() == null ? other.getBuyPrice() == null : this.getBuyPrice().equals(other.getBuyPrice()))
            && (this.getSpecificationModle() == null ? other.getSpecificationModle() == null : this.getSpecificationModle().equals(other.getSpecificationModle()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getMeasuringRange() == null ? other.getMeasuringRange() == null : this.getMeasuringRange().equals(other.getMeasuringRange()))
            && (this.getAccuracyLevel() == null ? other.getAccuracyLevel() == null : this.getAccuracyLevel().equals(other.getAccuracyLevel()))
            && (this.getLegalCategory() == null ? other.getLegalCategory() == null : this.getLegalCategory().equals(other.getLegalCategory()))
            && (this.getGaugeCategory() == null ? other.getGaugeCategory() == null : this.getGaugeCategory().equals(other.getGaugeCategory()))
            && (this.getSign() == null ? other.getSign() == null : this.getSign().equals(other.getSign()))
            && (this.getDescription1() == null ? other.getDescription1() == null : this.getDescription1().equals(other.getDescription1()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMeteringName() == null) ? 0 : getMeteringName().hashCode());
        result = prime * result + ((getMeteringNum() == null) ? 0 : getMeteringNum().hashCode());
        result = prime * result + ((getMeteringInspectionCycle() == null) ? 0 : getMeteringInspectionCycle().hashCode());
        result = prime * result + ((getBmName() == null) ? 0 : getBmName().hashCode());
        result = prime * result + ((getBuyTime() == null) ? 0 : getBuyTime().hashCode());
        result = prime * result + ((getUserXm() == null) ? 0 : getUserXm().hashCode());
        result = prime * result + ((getUpdateMessageTime() == null) ? 0 : getUpdateMessageTime().hashCode());
        result = prime * result + ((getThisMeteringTime() == null) ? 0 : getThisMeteringTime().hashCode());
        result = prime * result + ((getUtilType() == null) ? 0 : getUtilType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMeteringstatus() == null) ? 0 : getMeteringstatus().hashCode());
        result = prime * result + ((getMeteringSystemNum() == null) ? 0 : getMeteringSystemNum().hashCode());
        result = prime * result + ((getMeteringGetNumberTime() == null) ? 0 : getMeteringGetNumberTime().hashCode());
        result = prime * result + ((getRecordPerson() == null) ? 0 : getRecordPerson().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        result = prime * result + ((getIsCycle() == null) ? 0 : getIsCycle().hashCode());
        result = prime * result + ((getBuyPrice() == null) ? 0 : getBuyPrice().hashCode());
        result = prime * result + ((getSpecificationModle() == null) ? 0 : getSpecificationModle().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getMeasuringRange() == null) ? 0 : getMeasuringRange().hashCode());
        result = prime * result + ((getAccuracyLevel() == null) ? 0 : getAccuracyLevel().hashCode());
        result = prime * result + ((getLegalCategory() == null) ? 0 : getLegalCategory().hashCode());
        result = prime * result + ((getGaugeCategory() == null) ? 0 : getGaugeCategory().hashCode());
        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());
        result = prime * result + ((getDescription1() == null) ? 0 : getDescription1().hashCode());
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
        sb.append(", bmName=").append(bmName);
        sb.append(", buyTime=").append(buyTime);
        sb.append(", userXm=").append(userXm);
        sb.append(", updateMessageTime=").append(updateMessageTime);
        sb.append(", thisMeteringTime=").append(thisMeteringTime);
        sb.append(", utilType=").append(utilType);
        sb.append(", description=").append(description);
        sb.append(", meteringstatus=").append(meteringstatus);
        sb.append(", meteringSystemNum=").append(meteringSystemNum);
        sb.append(", meteringGetNumberTime=").append(meteringGetNumberTime);
        sb.append(", recordPerson=").append(recordPerson);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", isCycle=").append(isCycle);
        sb.append(", buyPrice=").append(buyPrice);
        sb.append(", specificationModle=").append(specificationModle);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", measuringRange=").append(measuringRange);
        sb.append(", accuracyLevel=").append(accuracyLevel);
        sb.append(", legalCategory=").append(legalCategory);
        sb.append(", gaugeCategory=").append(gaugeCategory);
        sb.append(", sign=").append(sign);
        sb.append(", description1=").append(description1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}