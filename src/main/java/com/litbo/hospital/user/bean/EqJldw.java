package com.litbo.hospital.user.bean;

public class EqJldw {
    private String eqJldwId;

    private String eqJldwName;

    private String bz;

    public String getEqJldwId() {
        return eqJldwId;
    }

    public void setEqJldwId(String eqJldwId) {
        this.eqJldwId = eqJldwId == null ? null : eqJldwId.trim();
    }

    public String getEqJldwName() {
        return eqJldwName;
    }

    public void setEqJldwName(String eqJldwName) {
        this.eqJldwName = eqJldwName == null ? null : eqJldwName.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}