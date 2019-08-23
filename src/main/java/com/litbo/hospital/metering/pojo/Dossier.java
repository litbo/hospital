package com.litbo.hospital.metering.pojo;

import java.io.Serializable;

/**
 * dossier
 * @author 
 */
public class Dossier implements Serializable {
    private Integer id;

    private String dossierNum;

    private String dossierName;

    private String beginTime;

    private String endTime;

    private String dossierNature;

    private String saveType;

    private Integer dossierType;

    private String description;

    private String fileLocaltion;

    private String recordTime;

    private String recordPerson;

    private String specification;

    private String manufacturer;

    private String buyTime;

    private String bmName;

    private String agent;

    private String eqId;

    private String description1;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDossierNum() {
        return dossierNum;
    }

    public void setDossierNum(String dossierNum) {
        this.dossierNum = dossierNum;
    }

    public String getDossierName() {
        return dossierName;
    }

    public void setDossierName(String dossierName) {
        this.dossierName = dossierName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDossierNature() {
        return dossierNature;
    }

    public void setDossierNature(String dossierNature) {
        this.dossierNature = dossierNature;
    }

    public String getSaveType() {
        return saveType;
    }

    public void setSaveType(String saveType) {
        this.saveType = saveType;
    }

    public Integer getDossierType() {
        return dossierType;
    }

    public void setDossierType(Integer dossierType) {
        this.dossierType = dossierType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileLocaltion() {
        return fileLocaltion;
    }

    public void setFileLocaltion(String fileLocaltion) {
        this.fileLocaltion = fileLocaltion;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordPerson() {
        return recordPerson;
    }

    public void setRecordPerson(String recordPerson) {
        this.recordPerson = recordPerson;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getEqId() {
        return eqId;
    }

    public void setEqId(String eqId) {
        this.eqId = eqId;
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
        Dossier other = (Dossier) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDossierNum() == null ? other.getDossierNum() == null : this.getDossierNum().equals(other.getDossierNum()))
            && (this.getDossierName() == null ? other.getDossierName() == null : this.getDossierName().equals(other.getDossierName()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getDossierNature() == null ? other.getDossierNature() == null : this.getDossierNature().equals(other.getDossierNature()))
            && (this.getSaveType() == null ? other.getSaveType() == null : this.getSaveType().equals(other.getSaveType()))
            && (this.getDossierType() == null ? other.getDossierType() == null : this.getDossierType().equals(other.getDossierType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getFileLocaltion() == null ? other.getFileLocaltion() == null : this.getFileLocaltion().equals(other.getFileLocaltion()))
            && (this.getRecordTime() == null ? other.getRecordTime() == null : this.getRecordTime().equals(other.getRecordTime()))
            && (this.getRecordPerson() == null ? other.getRecordPerson() == null : this.getRecordPerson().equals(other.getRecordPerson()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getBuyTime() == null ? other.getBuyTime() == null : this.getBuyTime().equals(other.getBuyTime()))
            && (this.getBmName() == null ? other.getBmName() == null : this.getBmName().equals(other.getBmName()))
            && (this.getAgent() == null ? other.getAgent() == null : this.getAgent().equals(other.getAgent()))
            && (this.getEqId() == null ? other.getEqId() == null : this.getEqId().equals(other.getEqId()))
            && (this.getDescription1() == null ? other.getDescription1() == null : this.getDescription1().equals(other.getDescription1()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDossierNum() == null) ? 0 : getDossierNum().hashCode());
        result = prime * result + ((getDossierName() == null) ? 0 : getDossierName().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getDossierNature() == null) ? 0 : getDossierNature().hashCode());
        result = prime * result + ((getSaveType() == null) ? 0 : getSaveType().hashCode());
        result = prime * result + ((getDossierType() == null) ? 0 : getDossierType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getFileLocaltion() == null) ? 0 : getFileLocaltion().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        result = prime * result + ((getRecordPerson() == null) ? 0 : getRecordPerson().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getBuyTime() == null) ? 0 : getBuyTime().hashCode());
        result = prime * result + ((getBmName() == null) ? 0 : getBmName().hashCode());
        result = prime * result + ((getAgent() == null) ? 0 : getAgent().hashCode());
        result = prime * result + ((getEqId() == null) ? 0 : getEqId().hashCode());
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
        sb.append(", dossierNum=").append(dossierNum);
        sb.append(", dossierName=").append(dossierName);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", dossierNature=").append(dossierNature);
        sb.append(", saveType=").append(saveType);
        sb.append(", dossierType=").append(dossierType);
        sb.append(", description=").append(description);
        sb.append(", fileLocaltion=").append(fileLocaltion);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", recordPerson=").append(recordPerson);
        sb.append(", specification=").append(specification);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", buyTime=").append(buyTime);
        sb.append(", bmName=").append(bmName);
        sb.append(", agent=").append(agent);
        sb.append(", eqId=").append(eqId);
        sb.append(", description1=").append(description1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}