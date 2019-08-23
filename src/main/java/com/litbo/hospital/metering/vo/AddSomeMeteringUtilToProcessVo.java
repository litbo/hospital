package com.litbo.hospital.metering.vo;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/15 22:58
 * @Version:
 * @Description:
 */
public class AddSomeMeteringUtilToProcessVo {
    private String utilIds;
    private String department;
    private String verificationUnit;
    private String dealAdvertisement; //（申请人）
    private String  processName; //（计划名称），
    private String dealPerson;//（审批人）



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getVerificationUnit() {
        return verificationUnit;
    }

    public void setVerificationUnit(String verificationUnit) {
        this.verificationUnit = verificationUnit;
    }

    public String getDealAdvertisement() {
        return dealAdvertisement;
    }

    public void setDealAdvertisement(String dealAdvertisement) {
        this.dealAdvertisement = dealAdvertisement;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getDealPerson() {
        return dealPerson;
    }

    public void setDealPerson(String dealPerson) {
        this.dealPerson = dealPerson;
    }

    public AddSomeMeteringUtilToProcessVo() {
    }

    public String getUtilIds() {
        return utilIds;
    }

    public void setUtilIds(String utilIds) {
        this.utilIds = utilIds;
    }

    public AddSomeMeteringUtilToProcessVo(String utilIds, String department, String verificationUnit, String dealAdvertisement, String processName, String dealPerson) {
        this.utilIds = utilIds;
        this.department = department;
        this.verificationUnit = verificationUnit;
        this.dealAdvertisement = dealAdvertisement;
        this.processName = processName;
        this.dealPerson = dealPerson;
    }
}
