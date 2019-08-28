package com.litbo.hospital.maintenance.pojo;

import java.io.Serializable;

/**
 * maintenance_project
 * @author 
 */
public class MaintenanceProject implements Serializable {
    private Integer id;

    private String projectType;

    private String projectName;

    private String projectLevel;

    private String standard;

    private String firstTime;

    private String implementerType;

    private String cycle;

    private String cycleUnit;

    private String result;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLevel() {
        return projectLevel;
    }

    public void setProjectLevel(String projectLevel) {
        this.projectLevel = projectLevel;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getImplementerType() {
        return implementerType;
    }

    public void setImplementerType(String implementerType) {
        this.implementerType = implementerType;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
        MaintenanceProject other = (MaintenanceProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectType() == null ? other.getProjectType() == null : this.getProjectType().equals(other.getProjectType()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectLevel() == null ? other.getProjectLevel() == null : this.getProjectLevel().equals(other.getProjectLevel()))
            && (this.getStandard() == null ? other.getStandard() == null : this.getStandard().equals(other.getStandard()))
            && (this.getFirstTime() == null ? other.getFirstTime() == null : this.getFirstTime().equals(other.getFirstTime()))
            && (this.getImplementerType() == null ? other.getImplementerType() == null : this.getImplementerType().equals(other.getImplementerType()))
            && (this.getCycle() == null ? other.getCycle() == null : this.getCycle().equals(other.getCycle()))
            && (this.getCycleUnit() == null ? other.getCycleUnit() == null : this.getCycleUnit().equals(other.getCycleUnit()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectType() == null) ? 0 : getProjectType().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectLevel() == null) ? 0 : getProjectLevel().hashCode());
        result = prime * result + ((getStandard() == null) ? 0 : getStandard().hashCode());
        result = prime * result + ((getFirstTime() == null) ? 0 : getFirstTime().hashCode());
        result = prime * result + ((getImplementerType() == null) ? 0 : getImplementerType().hashCode());
        result = prime * result + ((getCycle() == null) ? 0 : getCycle().hashCode());
        result = prime * result + ((getCycleUnit() == null) ? 0 : getCycleUnit().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectType=").append(projectType);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectLevel=").append(projectLevel);
        sb.append(", standard=").append(standard);
        sb.append(", firstTime=").append(firstTime);
        sb.append(", implementerType=").append(implementerType);
        sb.append(", cycle=").append(cycle);
        sb.append(", cycleUnit=").append(cycleUnit);
        sb.append(", result=").append(result);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}