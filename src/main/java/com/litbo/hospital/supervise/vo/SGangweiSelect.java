package com.litbo.hospital.supervise.vo;

import java.util.Date;

public class SGangweiSelect {
    private Integer gwId;
    private String gwName;
    private String gwLevel;


    private String gwZz;
    private String userId;
    private Date createTime;
    private String docUrl;
    private Integer gwZzZt;
    private Integer syTianshu;
    private Integer sySyts;
    private Integer zdXgcs;


    public Integer getGwId() {
        return gwId;
    }

    public void setGwId(Integer gwId) {
        this.gwId = gwId;
    }

    public String getGwName() {
        return gwName;
    }

    public void setGwName(String gwName) {
        this.gwName = gwName == null ? null : gwName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl == null ? null : docUrl.trim();
    }

    public String getGwLevel() {
        return gwLevel;
    }

    public void setGwLevel(String gwLevel) {
        this.gwLevel = gwLevel == null ? null : gwLevel.trim();
    }

    public String getGwZz() {
        return gwZz;
    }

    public void setGwZz(String gwZz) {
        this.gwZz = gwZz == null ? null : gwZz.trim();
    }

    public Integer getGwZzZt() {
        return gwZzZt;
    }

    public void setGwZzZt(Integer gwZzZt) {
        this.gwZzZt = gwZzZt;
    }

    public Integer getSyTianshu() {
        return syTianshu;
    }

    public void setSyTianshu(Integer syTianshu) {
        this.syTianshu = syTianshu;
    }

    public Integer getSySyts() {
        return sySyts;
    }

    public void setSySyts(Integer sySyts) {
        this.sySyts = sySyts;
    }

    public Integer getZdXgcs() {
        return zdXgcs;
    }

    public void setZdXgcs(Integer zdXgcs) {
        this.zdXgcs = zdXgcs;
    }
}