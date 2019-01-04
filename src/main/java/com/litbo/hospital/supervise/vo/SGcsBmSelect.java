package com.litbo.hospital.supervise.vo;

public class SGcsBmSelect {
    private Integer gbId;
    private String userId;
    private String userXm;
    private String bmId;
    private String bmName;

    public Integer getGbId() {
        return gbId;
    }

    public void setGbId(Integer gbId) {
        this.gbId = gbId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId == null ? null : bmId.trim();
    }

    public String getUserXm() {
        return userXm;
    }

    public void setUserXm(String userXm) {
        this.userXm = userXm;
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }
}