package com.litbo.hospital.beneficial.vo;

import lombok.Data;

import java.math.BigDecimal;
/*
* 直接成本VO
* */

public class ZjcbVo {

    private String bmName;

    private String eqName;

    private String eqNum;

    private String eqXh;

    private BigDecimal ryjf;

    private BigDecimal wsclf;

    private BigDecimal ypf;

    private BigDecimal gdzczjf;
    private BigDecimal ylsbzjf;

    private BigDecimal wxzctxf;

    private BigDecimal ylfxf;

    private BigDecimal qt;

    private BigDecimal zj;


    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    public String getEqNum() {
        return eqNum;
    }

    public void setEqNum(String eqNum) {
        this.eqNum = eqNum;
    }

    public String getEqXh() {
        return eqXh;
    }

    public void setEqXh(String eqXh) {
        this.eqXh = eqXh;
    }

    public BigDecimal getRyjf() {
        return ryjf;
    }

    public void setRyjf(BigDecimal ryjf) {
        this.ryjf = ryjf;
    }

    public BigDecimal getWsclf() {
        return wsclf;
    }

    public void setWsclf(BigDecimal wsclf) {
        this.wsclf = wsclf;
    }

    public BigDecimal getYpf() {
        return ypf;
    }

    public void setYpf(BigDecimal ypf) {
        this.ypf = ypf;
    }

    public BigDecimal getGdzczjf() {
        return gdzczjf;
    }

    public void setGdzczjf(BigDecimal gdzczjf) {
        this.gdzczjf = gdzczjf;
    }

    public BigDecimal getWxzctxf() {
        return wxzctxf;
    }

    public void setWxzctxf(BigDecimal wxzctxf) {
        this.wxzctxf = wxzctxf;
    }

    public BigDecimal getYlfxf() {
        return ylfxf;
    }

    public void setYlfxf(BigDecimal ylfxf) {
        this.ylfxf = ylfxf;
    }

    public BigDecimal getQt() {
        return qt;
    }

    public void setQt(BigDecimal qt) {
        this.qt = qt;
    }

    public BigDecimal getZj() {
        return zj;
    }

    public void setZj(BigDecimal zj) {
        this.zj = zj;
    }

    public BigDecimal getYlsbzjf() {
        return ylsbzjf;
    }

    public void setYlsbzjf(BigDecimal ylsbzjf) {
        this.ylsbzjf = ylsbzjf;
    }
}
