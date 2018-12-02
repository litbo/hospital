package com.litbo.hospital.supervise.bean;

import java.util.Date;

public class SZhidu {
    private Integer zdId;

    private String bmId;

    private String zdName;

    private String userId;

    private String docUrl;

    private Date createTime;

    private String zdContent;

    public Integer getZdId() {
        return zdId;
    }

    public void setZdId(Integer zdId) {
        this.zdId = zdId;
    }

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId == null ? null : bmId.trim();
    }

    public String getZdName() {
        return zdName;
    }

    public void setZdName(String zdName) {
        this.zdName = zdName == null ? null : zdName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl == null ? null : docUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getZdContent() {
        return zdContent;
    }

    public void setZdContent(String zdContent) {
        this.zdContent = zdContent == null ? null : zdContent.trim();
    }
}