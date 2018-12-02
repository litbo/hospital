package com.litbo.hospital.supervise.bean;

import java.util.Date;

public class SZhiduzhizeZt {
    private Integer ztId;

    private Integer zdId;

    private String userId;

    private Date ztDate;

    private String ztName;

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

    public String getZtName() {
        return ztName;
    }

    public void setZtName(String ztName) {
        this.ztName = ztName == null ? null : ztName.trim();
    }
}