package com.litbo.hospital.supervise.bean;

public class SGroupUser {
    private Integer guId;
    private Integer groupId;
    private String userId;
    private Integer gwId;

    public Integer getGuId() {
        return guId;
    }

    public void setGuId(Integer guId) {
        this.guId = guId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getGwId() {
        return gwId;
    }

    public void setGwId(Integer gwId) {
        this.gwId = gwId;
    }
}
