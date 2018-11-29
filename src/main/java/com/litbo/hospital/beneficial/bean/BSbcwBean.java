package com.litbo.hospital.beneficial.bean;

import java.math.BigDecimal;
import java.util.Date;

public class BSbcwBean {
    private Integer aId;

    private Integer ksId;

    private Integer eqId;

    private Date kmSj;

    private Integer kmNum;

    private String kmName;

    private BigDecimal kmValue;

    private Integer kmCjdm;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getKsId() {
        return ksId;
    }

    public void setKsId(Integer ksId) {
        this.ksId = ksId;
    }

    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }

    public Date getKmSj() {
        return kmSj;
    }

    public void setKmSj(Date kmSj) {
        this.kmSj = kmSj;
    }

    public Integer getKmNum() {
        return kmNum;
    }

    public void setKmNum(Integer kmNum) {
        this.kmNum = kmNum;
    }

    public String getKmName() {
        return kmName;
    }

    public void setKmName(String kmName) {
        this.kmName = kmName;
    }

    public BigDecimal getKmValue() {
        return kmValue;
    }

    public void setKmValue(BigDecimal kmValue) {
        this.kmValue = kmValue;
    }

    public Integer getKmCjdm() {
        return kmCjdm;
    }

    public void setKmCjdm(Integer kmCjdm) {
        this.kmCjdm = kmCjdm;
    }
}