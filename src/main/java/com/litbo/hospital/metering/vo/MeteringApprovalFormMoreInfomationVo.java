package com.litbo.hospital.metering.vo;

import com.litbo.hospital.metering.pojo.MeteringApprovalForm;
import com.litbo.hospital.metering.pojo.MeteringUtil;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/9 23:33
 * @Version:
 * @Description:
 */
public class MeteringApprovalFormMoreInfomationVo {
    private Integer formId;

    private String affiliateDepartment;

    private String formName;

    private String recordTime;

    private String dealStatus;

    private String dealTime;

    private List<MeteringUtil> utils;

    public MeteringApprovalFormMoreInfomationVo(MeteringApprovalForm form) {
        this.formId = form.getFormId();
        this.affiliateDepartment = form.getAffiliateDepartment();
        this.formName = form.getFormName();
        this.recordTime = form.getRecordTime();
        this.dealStatus = form.getDealStatus();
        this.dealTime = form.getDealTime();
    }

    @Override
    public String toString() {
        return "MeteringApprovalFormMoreInfomationVo{" +
                "formId=" + formId +
                ", affiliateDepartment='" + affiliateDepartment + '\'' +
                ", formName='" + formName + '\'' +
                ", recordTime='" + recordTime + '\'' +
                ", dealStatus='" + dealStatus + '\'' +
                ", dealTime='" + dealTime + '\'' +
                ", utils=" + utils +
                '}';
    }

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

    public List<MeteringUtil> getUtils() {
        return utils;
    }

    public void setUtils(List<MeteringUtil> utils) {
        this.utils = utils;
    }

    public MeteringApprovalFormMoreInfomationVo() {
    }
}
