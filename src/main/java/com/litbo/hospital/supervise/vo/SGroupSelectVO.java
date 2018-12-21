package com.litbo.hospital.supervise.vo;

import java.util.Date;

public class SGroupSelectVO {
    private Integer groupId;

    private String bmId;
    private String bmName;

    private String groupName;

    private String userId1;
    private String userName1;

    private Date createTime;

    private String userId2;
    private String userName2;

    private Date shTime;

    private String shFlag;

    private String shYj;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserId1() {
        return userId1;
    }

    public void setUserId1(String userId1) {
        this.userId1 = userId1;
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
        this.userId2 = userId2;
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
        this.shFlag = shFlag;
    }

    public String getShYj() {
        return shYj;
    }

    public void setShYj(String shYj) {
        this.shYj = shYj;
    }

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId;
    }

    public String getUserName1() {
        return userName1;
    }

    public void setUserName1(String userName1) {
        this.userName1 = userName1;
    }

    public String getUserName2() {
        return userName2;
    }

    public void setUserName2(String userName2) {
        this.userName2 = userName2;
    }
}
