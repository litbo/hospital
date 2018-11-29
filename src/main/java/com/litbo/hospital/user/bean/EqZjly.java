package com.litbo.hospital.user.bean;

public class EqZjly {
    private Integer zjlyId;

    private String zjlyName;

    public Integer getZjlyId() {
        return zjlyId;
    }

    public void setZjlyId(Integer zjlyId) {
        this.zjlyId = zjlyId;
    }

    public String getZjlyName() {
        return zjlyName;
    }

    public void setZjlyName(String zjlyName) {
        this.zjlyName = zjlyName == null ? null : zjlyName.trim();
    }
}