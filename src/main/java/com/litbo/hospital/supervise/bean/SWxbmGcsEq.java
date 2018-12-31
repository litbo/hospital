package com.litbo.hospital.supervise.bean;

public class SWxbmGcsEq {
    private Integer bgId;
    private String bmId;
    private String userId;
    private Integer eqId;

    public Integer getBgId() {
        return bgId;
    }

    public void setBgId(Integer bgId) {
        this.bgId = bgId;
    }

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId == null ? null : bmId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }
}
