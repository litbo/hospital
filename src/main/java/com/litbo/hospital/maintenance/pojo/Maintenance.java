package com.litbo.hospital.maintenance.pojo;

import java.io.Serializable;

/**
 * maintenance
 * @author 
 */
public class Maintenance implements Serializable {
    private Integer id;

    private String riskValue;   // 风险值

    private String formulator;  // 编制人

    private String reviewer;  // 审核人

    private String formTime; // 编制时间

    private String cycleRule;  // 周期规则

    private String cycle;  // 周期

    private String planType;  // 计划类型

    private String status;  // 计划状

    private String projectList; // 项目列表

    private String riskLevel; // 风险等级

    private String eqId;  // 设备id

    private String name; // 规范名称

    private String maintenanceResults; // 维护保养结果

    private String instrumentStatus; // 仪器现状

    private String description;  // 备注

    private String maintenancePersonnel;  // 维护人员

    private String checkTime;  // 检查日期

    private String departmentReceipt;  // 科室签收

    private String dateOfCompletion;  // 完成日期

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRiskValue() {
        return riskValue;
    }

    public void setRiskValue(String riskValue) {
        this.riskValue = riskValue;
    }

    public String getFormulator() {
        return formulator;
    }

    public void setFormulator(String formulator) {
        this.formulator = formulator;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getFormTime() {
        return formTime;
    }

    public void setFormTime(String formTime) {
        this.formTime = formTime;
    }

    public String getCycleRule() {
        return cycleRule;
    }

    public void setCycleRule(String cycleRule) {
        this.cycleRule = cycleRule;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
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

    public String getProjectList() {
        return projectList;
    }

    public void setProjectList(String projectList) {
        this.projectList = projectList;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getEqId() {
        return eqId;
    }

    public void setEqId(String eqId) {
        this.eqId = eqId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaintenanceResults() {
        return maintenanceResults;
    }

    public void setMaintenanceResults(String maintenanceResults) {
        this.maintenanceResults = maintenanceResults;
    }

    public String getInstrumentStatus() {
        return instrumentStatus;
    }

    public void setInstrumentStatus(String instrumentStatus) {
        this.instrumentStatus = instrumentStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaintenancePersonnel() {
        return maintenancePersonnel;
    }

    public void setMaintenancePersonnel(String maintenancePersonnel) {
        this.maintenancePersonnel = maintenancePersonnel;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getDepartmentReceipt() {
        return departmentReceipt;
    }

    public void setDepartmentReceipt(String departmentReceipt) {
        this.departmentReceipt = departmentReceipt;
    }

    public String getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(String dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
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
        Maintenance other = (Maintenance) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRiskValue() == null ? other.getRiskValue() == null : this.getRiskValue().equals(other.getRiskValue()))
            && (this.getFormulator() == null ? other.getFormulator() == null : this.getFormulator().equals(other.getFormulator()))
            && (this.getReviewer() == null ? other.getReviewer() == null : this.getReviewer().equals(other.getReviewer()))
            && (this.getFormTime() == null ? other.getFormTime() == null : this.getFormTime().equals(other.getFormTime()))
            && (this.getCycleRule() == null ? other.getCycleRule() == null : this.getCycleRule().equals(other.getCycleRule()))
            && (this.getCycle() == null ? other.getCycle() == null : this.getCycle().equals(other.getCycle()))
            && (this.getPlanType() == null ? other.getPlanType() == null : this.getPlanType().equals(other.getPlanType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProjectList() == null ? other.getProjectList() == null : this.getProjectList().equals(other.getProjectList()))
            && (this.getRiskLevel() == null ? other.getRiskLevel() == null : this.getRiskLevel().equals(other.getRiskLevel()))
            && (this.getEqId() == null ? other.getEqId() == null : this.getEqId().equals(other.getEqId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMaintenanceResults() == null ? other.getMaintenanceResults() == null : this.getMaintenanceResults().equals(other.getMaintenanceResults()))
            && (this.getInstrumentStatus() == null ? other.getInstrumentStatus() == null : this.getInstrumentStatus().equals(other.getInstrumentStatus()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMaintenancePersonnel() == null ? other.getMaintenancePersonnel() == null : this.getMaintenancePersonnel().equals(other.getMaintenancePersonnel()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
            && (this.getDepartmentReceipt() == null ? other.getDepartmentReceipt() == null : this.getDepartmentReceipt().equals(other.getDepartmentReceipt()))
            && (this.getDateOfCompletion() == null ? other.getDateOfCompletion() == null : this.getDateOfCompletion().equals(other.getDateOfCompletion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRiskValue() == null) ? 0 : getRiskValue().hashCode());
        result = prime * result + ((getFormulator() == null) ? 0 : getFormulator().hashCode());
        result = prime * result + ((getReviewer() == null) ? 0 : getReviewer().hashCode());
        result = prime * result + ((getFormTime() == null) ? 0 : getFormTime().hashCode());
        result = prime * result + ((getCycleRule() == null) ? 0 : getCycleRule().hashCode());
        result = prime * result + ((getCycle() == null) ? 0 : getCycle().hashCode());
        result = prime * result + ((getPlanType() == null) ? 0 : getPlanType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProjectList() == null) ? 0 : getProjectList().hashCode());
        result = prime * result + ((getRiskLevel() == null) ? 0 : getRiskLevel().hashCode());
        result = prime * result + ((getEqId() == null) ? 0 : getEqId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMaintenanceResults() == null) ? 0 : getMaintenanceResults().hashCode());
        result = prime * result + ((getInstrumentStatus() == null) ? 0 : getInstrumentStatus().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMaintenancePersonnel() == null) ? 0 : getMaintenancePersonnel().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getDepartmentReceipt() == null) ? 0 : getDepartmentReceipt().hashCode());
        result = prime * result + ((getDateOfCompletion() == null) ? 0 : getDateOfCompletion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", riskValue=").append(riskValue);
        sb.append(", formulator=").append(formulator);
        sb.append(", reviewer=").append(reviewer);
        sb.append(", formTime=").append(formTime);
        sb.append(", cycleRule=").append(cycleRule);
        sb.append(", cycle=").append(cycle);
        sb.append(", planType=").append(planType);
        sb.append(", status=").append(status);
        sb.append(", projectList=").append(projectList);
        sb.append(", riskLevel=").append(riskLevel);
        sb.append(", eqId=").append(eqId);
        sb.append(", name=").append(name);
        sb.append(", maintenanceResults=").append(maintenanceResults);
        sb.append(", instrumentStatus=").append(instrumentStatus);
        sb.append(", description=").append(description);
        sb.append(", maintenancePersonnel=").append(maintenancePersonnel);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", departmentReceipt=").append(departmentReceipt);
        sb.append(", dateOfCompletion=").append(dateOfCompletion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}