package com.litbo.hospital.supervise.vo;

public class WxBmGcsEqInsertVO {
    private String bmId;    //维修科室id
    private String userId;  //维修科室的人员
    private String[] eqIds; // 维修划分的设备

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getEqIds() {
        return eqIds;
    }

    public void setEqIds(String[] eqIds) {
        this.eqIds = eqIds;
    }
}
