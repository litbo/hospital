package com.litbo.hospital.supervise.bean;

import java.util.Date;

public class SGroup {
    private Integer groupId;

    private String bmId;

    private String groupName;

    private String userId1;

    private Date createTime;

    private String userId2;

    private Date shTime;

    private String shFlag;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId == null ? null : bmId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getUserId1() {
        return userId1;
    }

    public void setUserId1(String userId1) {
        this.userId1 = userId1 == null ? null : userId1.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId2() {
        return userId2;
    }

    public void setUserId2(String userId2) {
        this.userId2 = userId2 == null ? null : userId2.trim();
    }

    public Date getShTime() {
        return shTime;
    }

    public void setShTime(Date shTime) {
        this.shTime = shTime;
    }

    public String getShFlag() {
        return shFlag;
    }

    public void setShFlag(String shFlag) {
        this.shFlag = shFlag == null ? null : shFlag.trim();
    }
}