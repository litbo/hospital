package com.litbo.hospital.beneficial.bean;

public class BAccountBean {
    private Integer aId;

    private String fkmNum;

    private String fkmName;

    private String kmName;

    private String kmNum;

    private String kmCjdm;

    private String kmType;

    private String kmIssetin;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getFkmNum() {
        return fkmNum;
    }

    public void setFkmNum(String fkmNum) {
        this.fkmNum = fkmNum == null ? null : fkmNum.trim();
    }

    public String getFkmName() {
        return fkmName;
    }

    public void setFkmName(String fkmName) {
        this.fkmName = fkmName == null ? null : fkmName.trim();
    }

    public String getKmName() {
        return kmName;
    }

    public void setKmName(String kmName) {
        this.kmName = kmName == null ? null : kmName.trim();
    }

    public String getKmNum() {
        return kmNum;
    }

    public void setKmNum(String kmNum) {
        this.kmNum = kmNum == null ? null : kmNum.trim();
    }

    public String getKmCjdm() {
        return kmCjdm;
    }

    public void setKmCjdm(String kmCjdm) {
        this.kmCjdm = kmCjdm == null ? null : kmCjdm.trim();
    }

    public String getKmType() {
        return kmType;
    }

    public void setKmType(String kmType) {
        this.kmType = kmType == null ? null : kmType.trim();
    }

    public String getKmIssetin() {
        return kmIssetin;
    }

    public void setKmIssetin(String kmIssetin) {
        this.kmIssetin = kmIssetin == null ? null : kmIssetin.trim();
    }
}