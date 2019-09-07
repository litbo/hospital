package com.litbo.hospital.maintenance.vo;

import com.litbo.hospital.maintenance.pojo.Maintenance;

/**
 * @Author: 樊小铭
 * Date: 2019/8/28 11:44
 * @Version:
 * @Description:
 */
public class MaintenancePlanVo {
    private int id;
    private String name;
    private String recordTime;
    private String planType;
    private String status;

    @Override
    public String toString() {
        return "MaintenancePlanVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recordTime='" + recordTime + '\'' +
                ", planType='" + planType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MaintenancePlanVo() {
    }

    public MaintenancePlanVo(int id, String name, String recordTime, String planType, String status) {
        this.id = id;
        this.name = name;
        this.recordTime = recordTime;
        this.planType = planType;
        this.status = status;
    }


    public MaintenancePlanVo(Maintenance maintenance) {
        this.id = maintenance.getId();
        this.name = maintenance.getName();
        this.recordTime = maintenance.getFormTime();
        this.planType = maintenance.getPlanType();
        this.status = maintenance.getStatus();
    }
}
