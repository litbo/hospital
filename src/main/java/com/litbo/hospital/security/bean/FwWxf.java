package com.litbo.hospital.security.bean;

import java.util.Date;

public class FwWxf {
    private Integer id;

    private String user1Id;

    private String fwId;

    private Date wxfSqtime;

    private Double wxfRgf;

    private Double wxfCjrgf;

    private String user2Id;

    private Integer wxfStatus;

    private Date wxfSptime;

    private String wxfSpyj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id == null ? null : user1Id.trim();
    }

    public String getFwId() {
        return fwId;
    }

    public void setFwId(String fwId) {
        this.fwId = fwId == null ? null : fwId.trim();
    }

    public Date getWxfSqtime() {
        return wxfSqtime;
    }

    public void setWxfSqtime(Date wxfSqtime) {
        this.wxfSqtime = wxfSqtime;
    }

    public Double getWxfRgf() {
        return wxfRgf;
    }

    public void setWxfRgf(Double wxfRgf) {
        this.wxfRgf = wxfRgf;
    }

    public Double getWxfCjrgf() {
        return wxfCjrgf;
    }

    public void setWxfCjrgf(Double wxfCjrgf) {
        this.wxfCjrgf = wxfCjrgf;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id == null ? null : user2Id.trim();
    }

    public Integer getWxfStatus() {
        return wxfStatus;
    }

    public void setWxfStatus(Integer wxfStatus) {
        this.wxfStatus = wxfStatus;
    }

    public Date getWxfSptime() {
        return wxfSptime;
    }

    public void setWxfSptime(Date wxfSptime) {
        this.wxfSptime = wxfSptime;
    }

    public String getWxfSpyj() {
        return wxfSpyj;
    }

    public void setWxfSpyj(String wxfSpyj) {
        this.wxfSpyj = wxfSpyj == null ? null : wxfSpyj.trim();
    }
}