package com.litbo.hospital.security.specialequipment.bean;

public class SpecialEquipmentEmIsOrNo {
    private String userId;

    private Integer isSpem;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getIsSpem() {
        return isSpem;
    }

    public void setIsSpem(Integer isSpem) {
        this.isSpem = isSpem;
    }
}