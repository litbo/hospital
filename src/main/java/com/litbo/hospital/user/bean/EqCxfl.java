package com.litbo.hospital.user.bean;

public class EqCxfl {
    private String eqCxflId;

    private String eqCxflName;

    public String getEqCxflId() {
        return eqCxflId;
    }

    public void setEqCxflId(String eqCxflId) {
        this.eqCxflId = eqCxflId == null ? null : eqCxflId.trim();
    }

    public String getEqCxflName() {
        return eqCxflName;
    }

    public void setEqCxflName(String eqCxflName) {
        this.eqCxflName = eqCxflName == null ? null : eqCxflName.trim();
    }
}