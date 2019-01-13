package com.litbo.hospital.beneficial.bean;

import java.math.BigDecimal;
/*
* 附属设备
* */
public class BSbfsgxBean {
    private Integer aId;

    private Integer eqId;

    private Integer fssbId;

    private String fssbName;

    private String fssbNum;

    private BigDecimal sbFwzje;

    private BigDecimal sbQtzje;

    private BigDecimal sbZje;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }

    public Integer getFssbId() {
        return fssbId;
    }

    public void setFssbId(Integer fssbId) {
        this.fssbId = fssbId;
    }

    public String getFssbName() {
        return fssbName;
    }

    public void setFssbName(String fssbName) {
        this.fssbName = fssbName == null ? null : fssbName.trim();
    }

    public String getFssbNum() {
        return fssbNum;
    }

    public void setFssbNum(String fssbNum) {
        this.fssbNum = fssbNum == null ? null : fssbNum.trim();
    }

    public BigDecimal getSbFwzje() {
        return sbFwzje;
    }

    public void setSbFwzje(BigDecimal sbFwzje) {
        this.sbFwzje = sbFwzje;
    }

    public BigDecimal getSbQtzje() {
        return sbQtzje;
    }

    public void setSbQtzje(BigDecimal sbQtzje) {
        this.sbQtzje = sbQtzje;
    }

    public BigDecimal getSbZje() {
        return sbZje;
    }

    public void setSbZje(BigDecimal sbZje) {
        this.sbZje = sbZje;
    }
}