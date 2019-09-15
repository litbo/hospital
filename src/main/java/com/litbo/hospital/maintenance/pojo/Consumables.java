package com.litbo.hospital.maintenance.pojo;

import java.io.Serializable;

/**
 * consumables
 * @author 
 */
public class Consumables implements Serializable {
    private Integer id;

    private Integer maintenanceId; // 维护保养任务id

    private String productName; // 名称

    private String cycle;   //更换周期

    private String expired;  // 过期、更换

    private String notExpired;  // 未过期

    private String dateOfActivation;   // 起用日期

    private String changeDate;  // 更换日期

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getNotExpired() {
        return notExpired;
    }

    public void setNotExpired(String notExpired) {
        this.notExpired = notExpired;
    }

    public String getDateOfActivation() {
        return dateOfActivation;
    }

    public void setDateOfActivation(String dateOfActivation) {
        this.dateOfActivation = dateOfActivation;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
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
        Consumables other = (Consumables) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMaintenanceId() == null ? other.getMaintenanceId() == null : this.getMaintenanceId().equals(other.getMaintenanceId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getCycle() == null ? other.getCycle() == null : this.getCycle().equals(other.getCycle()))
            && (this.getExpired() == null ? other.getExpired() == null : this.getExpired().equals(other.getExpired()))
            && (this.getNotExpired() == null ? other.getNotExpired() == null : this.getNotExpired().equals(other.getNotExpired()))
            && (this.getDateOfActivation() == null ? other.getDateOfActivation() == null : this.getDateOfActivation().equals(other.getDateOfActivation()))
            && (this.getChangeDate() == null ? other.getChangeDate() == null : this.getChangeDate().equals(other.getChangeDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMaintenanceId() == null) ? 0 : getMaintenanceId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getCycle() == null) ? 0 : getCycle().hashCode());
        result = prime * result + ((getExpired() == null) ? 0 : getExpired().hashCode());
        result = prime * result + ((getNotExpired() == null) ? 0 : getNotExpired().hashCode());
        result = prime * result + ((getDateOfActivation() == null) ? 0 : getDateOfActivation().hashCode());
        result = prime * result + ((getChangeDate() == null) ? 0 : getChangeDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", maintenanceId=").append(maintenanceId);
        sb.append(", productName=").append(productName);
        sb.append(", cycle=").append(cycle);
        sb.append(", expired=").append(expired);
        sb.append(", notExpired=").append(notExpired);
        sb.append(", dateOfActivation=").append(dateOfActivation);
        sb.append(", changeDate=").append(changeDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}