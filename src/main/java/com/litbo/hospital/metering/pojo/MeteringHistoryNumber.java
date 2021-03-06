package com.litbo.hospital.metering.pojo;

import java.io.Serializable;

/**
 * metering_history_number
 * @author 
 */
public class MeteringHistoryNumber implements Serializable {
    private Integer id;

    private Integer meteringutilId;

    private String meteringutillNumber;

    private String getNumberTime;

    private String recordTime;

    private String recordPerson;

    private String verificationNumber;

    private String description;

    private String verificationUnit;

    private String effectiveDate;

    private String verificationResult;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeteringutilId() {
        return meteringutilId;
    }

    public void setMeteringutilId(Integer meteringutilId) {
        this.meteringutilId = meteringutilId;
    }

    public String getMeteringutillNumber() {
        return meteringutillNumber;
    }

    public void setMeteringutillNumber(String meteringutillNumber) {
        this.meteringutillNumber = meteringutillNumber;
    }

    public String getGetNumberTime() {
        return getNumberTime;
    }

    public void setGetNumberTime(String getNumberTime) {
        this.getNumberTime = getNumberTime;
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

    public String getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(String verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVerificationUnit() {
        return verificationUnit;
    }

    public void setVerificationUnit(String verificationUnit) {
        this.verificationUnit = verificationUnit;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResult(String verificationResult) {
        this.verificationResult = verificationResult;
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
        MeteringHistoryNumber other = (MeteringHistoryNumber) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMeteringutilId() == null ? other.getMeteringutilId() == null : this.getMeteringutilId().equals(other.getMeteringutilId()))
            && (this.getMeteringutillNumber() == null ? other.getMeteringutillNumber() == null : this.getMeteringutillNumber().equals(other.getMeteringutillNumber()))
            && (this.getGetNumberTime() == null ? other.getGetNumberTime() == null : this.getGetNumberTime().equals(other.getGetNumberTime()))
            && (this.getRecordTime() == null ? other.getRecordTime() == null : this.getRecordTime().equals(other.getRecordTime()))
            && (this.getRecordPerson() == null ? other.getRecordPerson() == null : this.getRecordPerson().equals(other.getRecordPerson()))
            && (this.getVerificationNumber() == null ? other.getVerificationNumber() == null : this.getVerificationNumber().equals(other.getVerificationNumber()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getVerificationUnit() == null ? other.getVerificationUnit() == null : this.getVerificationUnit().equals(other.getVerificationUnit()))
            && (this.getEffectiveDate() == null ? other.getEffectiveDate() == null : this.getEffectiveDate().equals(other.getEffectiveDate()))
            && (this.getVerificationResult() == null ? other.getVerificationResult() == null : this.getVerificationResult().equals(other.getVerificationResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMeteringutilId() == null) ? 0 : getMeteringutilId().hashCode());
        result = prime * result + ((getMeteringutillNumber() == null) ? 0 : getMeteringutillNumber().hashCode());
        result = prime * result + ((getGetNumberTime() == null) ? 0 : getGetNumberTime().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        result = prime * result + ((getRecordPerson() == null) ? 0 : getRecordPerson().hashCode());
        result = prime * result + ((getVerificationNumber() == null) ? 0 : getVerificationNumber().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getVerificationUnit() == null) ? 0 : getVerificationUnit().hashCode());
        result = prime * result + ((getEffectiveDate() == null) ? 0 : getEffectiveDate().hashCode());
        result = prime * result + ((getVerificationResult() == null) ? 0 : getVerificationResult().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", meteringutilId=").append(meteringutilId);
        sb.append(", meteringutillNumber=").append(meteringutillNumber);
        sb.append(", getNumberTime=").append(getNumberTime);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", recordPerson=").append(recordPerson);
        sb.append(", verificationNumber=").append(verificationNumber);
        sb.append(", description=").append(description);
        sb.append(", verificationUnit=").append(verificationUnit);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append(", verificationResult=").append(verificationResult);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}