package com.litbo.hospital.metering.pojo;

import java.io.Serializable;

/**
 * dossier_file
 * @author 
 */
public class DossierFile implements Serializable {
    private Integer id;

    private String belongDossierNum;

    private String belongDossierName;

    private String specification;

    private String manufacturer;

    private String buyTime;

    private String bmName;

    private String agent;

    private String fileNum;

    private String fileName;

    private String fileDate;

    private String fileSize;

    private String summary;

    private String description;

    private String fileUrl;

    private String recordTime;

    private String recordPerson;

    private Integer fileType;

    private String description1;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBelongDossierNum() {
        return belongDossierNum;
    }

    public void setBelongDossierNum(String belongDossierNum) {
        this.belongDossierNum = belongDossierNum;
    }

    public String getBelongDossierName() {
        return belongDossierName;
    }

    public void setBelongDossierName(String belongDossierName) {
        this.belongDossierName = belongDossierName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getFileNum() {
        return fileNum;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordPerson() {
        return recordPerson;
    }

    public void setRecordPerson(String recordPerson) {
        this.recordPerson = recordPerson;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
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
        DossierFile other = (DossierFile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBelongDossierNum() == null ? other.getBelongDossierNum() == null : this.getBelongDossierNum().equals(other.getBelongDossierNum()))
            && (this.getBelongDossierName() == null ? other.getBelongDossierName() == null : this.getBelongDossierName().equals(other.getBelongDossierName()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getManufacturer() == null ? other.getManufacturer() == null : this.getManufacturer().equals(other.getManufacturer()))
            && (this.getBuyTime() == null ? other.getBuyTime() == null : this.getBuyTime().equals(other.getBuyTime()))
            && (this.getBmName() == null ? other.getBmName() == null : this.getBmName().equals(other.getBmName()))
            && (this.getAgent() == null ? other.getAgent() == null : this.getAgent().equals(other.getAgent()))
            && (this.getFileNum() == null ? other.getFileNum() == null : this.getFileNum().equals(other.getFileNum()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileDate() == null ? other.getFileDate() == null : this.getFileDate().equals(other.getFileDate()))
            && (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()))
            && (this.getRecordTime() == null ? other.getRecordTime() == null : this.getRecordTime().equals(other.getRecordTime()))
            && (this.getRecordPerson() == null ? other.getRecordPerson() == null : this.getRecordPerson().equals(other.getRecordPerson()))
            && (this.getFileType() == null ? other.getFileType() == null : this.getFileType().equals(other.getFileType()))
            && (this.getDescription1() == null ? other.getDescription1() == null : this.getDescription1().equals(other.getDescription1()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBelongDossierNum() == null) ? 0 : getBelongDossierNum().hashCode());
        result = prime * result + ((getBelongDossierName() == null) ? 0 : getBelongDossierName().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getManufacturer() == null) ? 0 : getManufacturer().hashCode());
        result = prime * result + ((getBuyTime() == null) ? 0 : getBuyTime().hashCode());
        result = prime * result + ((getBmName() == null) ? 0 : getBmName().hashCode());
        result = prime * result + ((getAgent() == null) ? 0 : getAgent().hashCode());
        result = prime * result + ((getFileNum() == null) ? 0 : getFileNum().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileDate() == null) ? 0 : getFileDate().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        result = prime * result + ((getRecordPerson() == null) ? 0 : getRecordPerson().hashCode());
        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());
        result = prime * result + ((getDescription1() == null) ? 0 : getDescription1().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", belongDossierNum=").append(belongDossierNum);
        sb.append(", belongDossierName=").append(belongDossierName);
        sb.append(", specification=").append(specification);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", buyTime=").append(buyTime);
        sb.append(", bmName=").append(bmName);
        sb.append(", agent=").append(agent);
        sb.append(", fileNum=").append(fileNum);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileDate=").append(fileDate);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", summary=").append(summary);
        sb.append(", description=").append(description);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", recordPerson=").append(recordPerson);
        sb.append(", fileType=").append(fileType);
        sb.append(", description1=").append(description1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}