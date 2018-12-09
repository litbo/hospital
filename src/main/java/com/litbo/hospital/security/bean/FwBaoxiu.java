package com.litbo.hospital.security.bean;

import java.util.Date;

public class FwBaoxiu {
    private String id;

    private Integer eqId;

    private String bxrId;

    private String bxfs;

    private String bxrdh;

    private String bxksId;

    private String bxksdh;

    private Date bxTime;

    private Date fxTime;

    private Integer jjxStatus;

    private Integer bxStatus;

    private String gzxx;

    private Integer zzStatus;

    private Date zzTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }

    public String getBxrId() {
        return bxrId;
    }

    public void setBxrId(String bxrId) {
        this.bxrId = bxrId == null ? null : bxrId.trim();
    }

    public String getBxfs() {
        return bxfs;
    }

    public void setBxfs(String bxfs) {
        this.bxfs = bxfs == null ? null : bxfs.trim();
    }

    public String getBxrdh() {
        return bxrdh;
    }

    public void setBxrdh(String bxrdh) {
        this.bxrdh = bxrdh == null ? null : bxrdh.trim();
    }

    public String getBxksId() {
        return bxksId;
    }

    public void setBxksId(String bxksId) {
        this.bxksId = bxksId == null ? null : bxksId.trim();
    }

    public String getBxksdh() {
        return bxksdh;
    }

    public void setBxksdh(String bxksdh) {
        this.bxksdh = bxksdh == null ? null : bxksdh.trim();
    }

    public Date getBxTime() {
        return bxTime;
    }

    public void setBxTime(Date bxTime) {
        this.bxTime = bxTime;
    }

    public Date getFxTime() {
        return fxTime;
    }

    public void setFxTime(Date fxTime) {
        this.fxTime = fxTime;
    }

    public Integer getJjxStatus() {
        return jjxStatus;
    }

    public void setJjxStatus(Integer jjxStatus) {
        this.jjxStatus = jjxStatus;
    }

    public Integer getBxStatus() {
        return bxStatus;
    }

    public void setBxStatus(Integer bxStatus) {
        this.bxStatus = bxStatus;
    }

    public String getGzxx() {
        return gzxx;
    }

    public void setGzxx(String gzxx) {
        this.gzxx = gzxx == null ? null : gzxx.trim();
    }

    public Integer getZzStatus() {
        return zzStatus;
    }

    public void setZzStatus(Integer zzStatus) {
        this.zzStatus = zzStatus;
    }

    public Date getZzTime() {
        return zzTime;
    }

    public void setZzTime(Date zzTime) {
        this.zzTime = zzTime;
    }
}