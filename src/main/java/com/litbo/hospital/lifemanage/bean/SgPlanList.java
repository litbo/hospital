package com.litbo.hospital.lifemanage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SgPlanList {
    public SgPlanList(String bmName, String id, String userId, String bmId, String planName, Date planDate) {
        this.bmName = bmName;
        this.id = id;
        this.userId = userId;
        this.bmId = bmId;
        this.planName = planName;
        this.planDate = planDate;
    }

    public SgPlanList() {
    }

    public SgPlanList(String bmName, String id, String userId, String bmId, String planName,
                      Date planDate, Integer allNum, Integer yiPanNum, Integer panYingNum, Integer panKuiNum) {
        this.bmName = bmName;
        this.id = id;
        this.userId = userId;
        this.bmId = bmId;
        this.planName = planName;
        this.planDate = planDate;
        this.allNum = allNum;
        this.yiPanNum = yiPanNum;
        this.panYingNum = panYingNum;
        this.panKuiNum = panKuiNum;
    }

    /**
     * 主键
     */

    private String bmName;
    private String id;

    /**
     * 制定人 接收为制定人id 返回为制定人名字
     */
    private String userId;
    /**
     * 科室id
     */
    private String bmId;

    /**
     * 计划名称
     */
    private String planName;

    /**
     * 计划时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date planDate;
    private Integer allNum;
    private  Integer yiPanNum;
    private Integer panYingNum;
    private Integer panKuiNum;

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    public Integer getYiPanNum() {
        return yiPanNum;
    }

    public void setYiPanNum(Integer yiPanNum) {
        this.yiPanNum = yiPanNum;
    }

    public Integer getPanYingNum() {
        return panYingNum;
    }

    public void setPanYingNum(Integer panYingNum) {
        this.panYingNum = panYingNum;
    }

    public Integer getPanKuiNum() {
        return panKuiNum;
    }

    public void setPanKuiNum(Integer panKuiNum) {
        this.panKuiNum = panKuiNum;
    }

    @Override
    public String toString() {
        return "SgPlanList{" +
                "bmName='" + bmName + '\'' +
                ", id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", bmId='" + bmId + '\'' +
                ", planName='" + planName + '\'' +
                ", planDate=" + planDate +
                ", allNum=" + allNum +
                ", yiPanNum=" + yiPanNum +
                ", panYingNum=" + panYingNum +
                ", panKuiNum=" + panKuiNum +
                '}';
    }
}
