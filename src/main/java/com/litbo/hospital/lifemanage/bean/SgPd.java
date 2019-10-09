package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

@Data
public class SgPd {
    /**
     *盘点流水号
     */
    private String pdId;
    /**
     *扫描到的编号
     */
    private String pdScanId;
    /**
     *盘点上传时间
     */
    private String pdScsj;
    /**
     *盘点操作人
     */
    private String pdCzr;
    /**
     *本次盘点的科室id
     */
    private String pdBmId;
    /**
     *该科室盘点状态
     */
    private String pdBmzt;
    /**
     *盘点计划id
     */
    private String pdJhid;
    /**
     *盘点完成时间
     */
    private Date pdWcsj;

    public String getPdId() {
        return pdId;
    }

    public void setPdId(String pdId) {
        this.pdId = pdId;
    }

    public String getPdScanId() {
        return pdScanId;
    }

    public void setPdScanId(String pdScanId) {
        this.pdScanId = pdScanId;
    }

    public String getPdScsj() {
        return pdScsj;
    }

    public void setPdScsj(String pdScsj) {
        this.pdScsj = pdScsj;
    }

    public String getPdCzr() {
        return pdCzr;
    }

    public void setPdCzr(String pdCzr) {
        this.pdCzr = pdCzr;
    }

    public String getPdBmId() {
        return pdBmId;
    }

    public void setPdBmId(String pdBmId) {
        this.pdBmId = pdBmId;
    }

    public String getPdBmzt() {
        return pdBmzt;
    }

    public void setPdBmzt(String pdBmzt) {
        this.pdBmzt = pdBmzt;
    }

    public String getPdJhid() {
        return pdJhid;
    }

    public void setPdJhid(String pdJhid) {
        this.pdJhid = pdJhid;
    }

    public Date getPdWcsj() {
        return pdWcsj;
    }

    public void setPdWcsj(Date pdWcsj) {
        this.pdWcsj = pdWcsj;
    }
}