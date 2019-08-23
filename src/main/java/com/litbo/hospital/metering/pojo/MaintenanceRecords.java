package com.litbo.hospital.metering.pojo;

import java.io.Serializable;

/**
 * maintenance_records
 * @author 
 */
public class MaintenanceRecords implements Serializable {
    private Integer id;

    private Integer meteringUtilId;

    private String repairMan;

    private String repairTime;

    private String faultDescription;

    private String repairContent;

    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeteringUtilId() {
        return meteringUtilId;
    }

    public void setMeteringUtilId(Integer meteringUtilId) {
        this.meteringUtilId = meteringUtilId;
    }

    public String getRepairMan() {
        return repairMan;
    }

    public void setRepairMan(String repairMan) {
        this.repairMan = repairMan;
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        MaintenanceRecords other = (MaintenanceRecords) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMeteringUtilId() == null ? other.getMeteringUtilId() == null : this.getMeteringUtilId().equals(other.getMeteringUtilId()))
            && (this.getRepairMan() == null ? other.getRepairMan() == null : this.getRepairMan().equals(other.getRepairMan()))
            && (this.getRepairTime() == null ? other.getRepairTime() == null : this.getRepairTime().equals(other.getRepairTime()))
            && (this.getFaultDescription() == null ? other.getFaultDescription() == null : this.getFaultDescription().equals(other.getFaultDescription()))
            && (this.getRepairContent() == null ? other.getRepairContent() == null : this.getRepairContent().equals(other.getRepairContent()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMeteringUtilId() == null) ? 0 : getMeteringUtilId().hashCode());
        result = prime * result + ((getRepairMan() == null) ? 0 : getRepairMan().hashCode());
        result = prime * result + ((getRepairTime() == null) ? 0 : getRepairTime().hashCode());
        result = prime * result + ((getFaultDescription() == null) ? 0 : getFaultDescription().hashCode());
        result = prime * result + ((getRepairContent() == null) ? 0 : getRepairContent().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", meteringUtilId=").append(meteringUtilId);
        sb.append(", repairMan=").append(repairMan);
        sb.append(", repairTime=").append(repairTime);
        sb.append(", faultDescription=").append(faultDescription);
        sb.append(", repairContent=").append(repairContent);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}