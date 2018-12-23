package com.litbo.hospital.supervise.bean;

import java.util.Date;

public class SZhiduzhizeZt {
    private Integer ztId;

    private Integer zdId;

    private String userId;

    private Date ztDate;

    private String ztCzname;

    private Integer ztCzzt;

    private String ztShyj;

    public Integer getZtId() {
        return ztId;
    }

    public void setZtId(Integer ztId) {
        this.ztId = ztId;
    }

    public Integer getZdId() {
        return zdId;
    }

    public void setZdId(Integer zdId) {
        this.zdId = zdId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getZtDate() {
        return ztDate;
    }

    public void setZtDate(Date ztDate) {
        this.ztDate = ztDate;
    }

    public String getZtCzname() {
        return ztCzname;
    }

    public void setZtCzname(String ztCzname) {
        this.ztCzname = ztCzname;
    }

    public Integer getZtCzzt() {
        return ztCzzt;
    }

    public void setZtCzzt(Integer ztCzzt) {
        this.ztCzzt = ztCzzt;
    }

    public String getZtShyj() {
        return ztShyj;
    }

    public void setZtShyj(String ztShyj) {
        this.ztShyj = ztShyj;
    }
}