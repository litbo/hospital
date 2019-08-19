package com.litbo.hospital.metering.vo;

import com.litbo.hospital.metering.pojo.MeteringApprovalForm;
import com.litbo.hospital.metering.pojo.MeteringDealProcess;
import com.litbo.hospital.metering.pojo.MeteringUtil;

import java.util.Date;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/9 23:03
 * @Version:
 * @Description:
 */
public class MeteringProcessMoreInformationVo {
    private Integer processId;

    private String dealPerson;

    private String dealTime;

    private String dealAdvertisement;

    private String dealStatus;

    private String department;

    private String processName;

    private String recordTime;

    private List<MeteringUtil> forms;

    public MeteringProcessMoreInformationVo() {
    }

    public MeteringProcessMoreInformationVo(MeteringDealProcess process) {
        this.processId = process.getProcessId();
        this.dealPerson = process.getDealPerson();
        this.dealTime = process.getDealTime();
        this.dealAdvertisement = process.getDealAdvertisement();
        this.dealStatus = process.getDealStatus();
        this.department = process.getDepartment();
        this.processName = process.getProcessName();
        this.recordTime = process.getRecordTime();
    }


    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealAdvertisement() {
        return dealAdvertisement;
    }

    public void setDealAdvertisement(String dealAdvertisement) {
        this.dealAdvertisement = dealAdvertisement;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public String toString() {
        return "MeteringProcessMoreInformationVo{" +
                "processId=" + processId +
                ", dealPerson='" + dealPerson + '\'' +
                ", dealTime='" + dealTime + '\'' +
                ", dealAdvertisement='" + dealAdvertisement + '\'' +
                ", dealStatus='" + dealStatus + '\'' +
                ", department='" + department + '\'' +
                ", processName='" + processName + '\'' +
                ", recordTime='" + recordTime + '\'' +
                ", forms=" + forms +
                '}';
    }

    public List<MeteringUtil> getForms() {
        return forms;
    }

    public void setForms(List<MeteringUtil> forms) {
        this.forms = forms;
    }
}
