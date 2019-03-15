package com.litbo.hospital.supervise.bean;

public class SBm {

    private String obmId;

    private String bmId;

    /**
     * 托管部门id 和bmId相同
     */
    private String tgBmId;

    private String bmName;

    private String userId;

    private String bmTel;

    private String bmAddr;

    private String wxFlag;

    private String pBmId;

    private String xbmFlag;

    public String getTgBmId() {
        return tgBmId;
    }

    public void setTgBmId(String tgBmId) {
        this.tgBmId = tgBmId;
    }

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId == null ? null : bmId.trim();
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName == null ? null : bmName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBmTel() {
        return bmTel;
    }

    public void setBmTel(String bmTel) {
        this.bmTel = bmTel == null ? null : bmTel.trim();
    }

    public String getBmAddr() {
        return bmAddr;
    }

    public void setBmAddr(String bmAddr) {
        this.bmAddr = bmAddr == null ? null : bmAddr.trim();
    }

    public String getWxFlag() {
        return wxFlag;
    }

    public void setWxFlag(String wxFlag) {
        this.wxFlag = wxFlag == null ? null : wxFlag.trim();
    }

    public String getpBmId() {
        return pBmId;
    }

    public void setpBmId(String pBmId) {
        this.pBmId = pBmId == null ? null : pBmId.trim();
    }

    public String getObmId() {
        return obmId;
    }

    public void setObmId(String obmId) {
        this.obmId = obmId;
    }

    public String getXbmFlag() {
        return xbmFlag;
    }

    public void setXbmFlag(String xbmFlag) {
        this.xbmFlag = xbmFlag;
    }
}