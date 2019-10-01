package com.litbo.hospital.supervise.bean;

public class SBm {

    private String obmId;

    private String bmId;

    /**
     * 托管科室id 和bmId相同
     */
    private String tgBmId;

    private String bmName;

    private String userId;

    private String bmTel;

    private String bmAddr;

    private String wxFlag;

    private String pBmId;

    private String xbmFlag;
    private String initFlag;

    public String getObmId() {
        return obmId;
    }

    public void setObmId(String obmId) {
        this.obmId = obmId;
    }

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId;
    }

    public String getTgBmId() {
        return tgBmId;
    }

    public void setTgBmId(String tgBmId) {
        this.tgBmId = tgBmId;
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBmTel() {
        return bmTel;
    }

    public void setBmTel(String bmTel) {
        this.bmTel = bmTel;
    }

    public String getBmAddr() {
        return bmAddr;
    }

    public void setBmAddr(String bmAddr) {
        this.bmAddr = bmAddr;
    }

    public String getWxFlag() {
        return wxFlag;
    }

    public void setWxFlag(String wxFlag) {
        this.wxFlag = wxFlag;
    }

    public String getpBmId() {
        return pBmId;
    }

    public void setpBmId(String pBmId) {
        this.pBmId = pBmId;
    }

    public String getXbmFlag() {
        return xbmFlag;
    }

    public void setXbmFlag(String xbmFlag) {
        this.xbmFlag = xbmFlag;
    }

    public String getInitFlag() {
        return initFlag;
    }

    public void setInitFlag(String initFlag) {
        this.initFlag = initFlag;
    }
}