package com.litbo.hospital.supervise.vo;

import java.util.Date;

public class ShMsgVO {
    private Integer ztId;
    private Integer ztCzzt;   // 0待审核 1 不通过 2 通过
    private Integer syDays; // 试用天数
    private Date ztDate;
    private String ztShyj;

    private Integer zdId;   //和nextShrId插入新的审核状态
    private String nextShrId;

    public Integer getZtId() {
        return ztId;
    }

    public void setZtId(Integer ztId) {
        this.ztId = ztId;
    }

    public Integer getZtCzzt() {
        return ztCzzt;
    }

    public void setZtCzzt(Integer ztCzzt) {
        this.ztCzzt = ztCzzt;
    }

    public Date getZtDate() {
        return ztDate;
    }

    public void setZtDate(Date ztDate) {
        this.ztDate = ztDate;
    }

    public String getZtShyj() {
        return ztShyj;
    }

    public void setZtShyj(String ztShyj) {
        this.ztShyj = ztShyj;
    }

    public String getNextShrId() {
        return nextShrId;
    }

    public void setNextShrId(String nextShrId) {
        this.nextShrId = nextShrId;
    }

    public Integer getZdId() {
        return zdId;
    }

    public void setZdId(Integer zdId) {
        this.zdId = zdId;
    }

    public Integer getSyDays() {
        return syDays;
    }

    public void setSyDays(Integer syDays) {
        this.syDays = syDays;
    }
}
