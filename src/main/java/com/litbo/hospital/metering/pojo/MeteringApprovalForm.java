package com.litbo.hospital.metering.pojo;

import java.io.Serializable;

/**
 * metering_approval_form
 * @author 
 */
public class MeteringApprovalForm implements Serializable {
    private Integer formId;

    private String affiliateDepartment;

    private String formName;

    private String meteringId;

    private String recordTime;

    private String dealStatus;

    private String dealTime;

    private static final long serialVersionUID = 1L;

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public String getAffiliateDepartment() {
        return affiliateDepartment;
    }

    public void setAffiliateDepartment(String affiliateDepartment) {
        this.affiliateDepartment = affiliateDepartment;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getMeteringId() {
        return meteringId;
    }

    public void setMeteringId(String meteringId) {
        this.meteringId = meteringId;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
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
        MeteringApprovalForm other = (MeteringApprovalForm) that;
        return (this.getFormId() == null ? other.getFormId() == null : this.getFormId().equals(other.getFormId()))
            && (this.getAffiliateDepartment() == null ? other.getAffiliateDepartment() == null : this.getAffiliateDepartment().equals(other.getAffiliateDepartment()))
            && (this.getFormName() == null ? other.getFormName() == null : this.getFormName().equals(other.getFormName()))
            && (this.getMeteringId() == null ? other.getMeteringId() == null : this.getMeteringId().equals(other.getMeteringId()))
            && (this.getRecordTime() == null ? other.getRecordTime() == null : this.getRecordTime().equals(other.getRecordTime()))
            && (this.getDealStatus() == null ? other.getDealStatus() == null : this.getDealStatus().equals(other.getDealStatus()))
            && (this.getDealTime() == null ? other.getDealTime() == null : this.getDealTime().equals(other.getDealTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFormId() == null) ? 0 : getFormId().hashCode());
        result = prime * result + ((getAffiliateDepartment() == null) ? 0 : getAffiliateDepartment().hashCode());
        result = prime * result + ((getFormName() == null) ? 0 : getFormName().hashCode());
        result = prime * result + ((getMeteringId() == null) ? 0 : getMeteringId().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        result = prime * result + ((getDealStatus() == null) ? 0 : getDealStatus().hashCode());
        result = prime * result + ((getDealTime() == null) ? 0 : getDealTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", formId=").append(formId);
        sb.append(", affiliateDepartment=").append(affiliateDepartment);
        sb.append(", formName=").append(formName);
        sb.append(", meteringId=").append(meteringId);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", dealStatus=").append(dealStatus);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}