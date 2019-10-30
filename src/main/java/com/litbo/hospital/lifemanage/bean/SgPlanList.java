package com.litbo.hospital.lifemanage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SgPlanList {


    /**
     * 主键
     */

    private  String fileStatus;
    private String checkStatus;
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



    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public SgPlanList(String fileStatus, String checkStatus, String bmName, String id, String userId, String bmId, String planName, Date planDate, Integer allNum, Integer yiPanNum, Integer panYingNum, Integer panKuiNum) {
        this.fileStatus = fileStatus;
        this.checkStatus = checkStatus;
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

    public SgPlanList() {
    }

    @Override
    public String toString() {
        return "SgPlanList{" +
                "fileStatus='" + fileStatus + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", bmName='" + bmName + '\'' +
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

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }


}
