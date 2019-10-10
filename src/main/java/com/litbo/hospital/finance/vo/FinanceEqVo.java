package com.litbo.hospital.finance.vo;

import com.litbo.hospital.finance.pojo.Finance;

/**
 * @Author: 樊小铭
 * Date: 2019/10/10 13:30
 * @Version:
 * @Description:
 */
public class FinanceEqVo {

    private String eqNum;  // 设备编号

    private String eqName; // 设备名称

    private String xh; // 型号

    private String bm;  // 科室

    private String tzfa;  // 投资方案

    private String avgDay;  // 日平均成本

    private String bld;  // 保利点

    private String bbd; // 保本点

    private String bbdzyl; // 保本点作用率

    private String aqbj; // 安全边际

    @Override
    public String toString() {
        return "FinanceEqVo{" +
                "eqNum='" + eqNum + '\'' +
                ", eqName='" + eqName + '\'' +
                ", xh='" + xh + '\'' +
                ", bm='" + bm + '\'' +
                ", tzfa='" + tzfa + '\'' +
                ", avgDay='" + avgDay + '\'' +
                ", bld='" + bld + '\'' +
                ", bbd='" + bbd + '\'' +
                ", bbdzyl='" + bbdzyl + '\'' +
                ", aqbj='" + aqbj + '\'' +
                '}';
    }

    public String getEqNum() {
        return eqNum;
    }

    public void setEqNum(String eqNum) {
        this.eqNum = eqNum;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getTzfa() {
        return tzfa;
    }

    public void setTzfa(String tzfa) {
        this.tzfa = tzfa;
    }

    public String getAvgDay() {
        return avgDay;
    }

    public void setAvgDay(String avgDay) {
        this.avgDay = avgDay;
    }

    public String getBld() {
        return bld;
    }

    public void setBld(String bld) {
        this.bld = bld;
    }

    public String getBbd() {
        return bbd;
    }

    public void setBbd(String bbd) {
        this.bbd = bbd;
    }

    public String getBbdzyl() {
        return bbdzyl;
    }

    public void setBbdzyl(String bbdzyl) {
        this.bbdzyl = bbdzyl;
    }

    public String getAqbj() {
        return aqbj;
    }

    public void setAqbj(String aqbj) {
        this.aqbj = aqbj;
    }

    public FinanceEqVo() {
    }

    public FinanceEqVo(String eqNum, String eqName, String xh, String bm, String tzfa, String avgDay, String bld, String bbd, String bbdzyl, String aqbj) {
        this.eqNum = eqNum;
        this.eqName = eqName;
        this.xh = xh;
        this.bm = bm;
        this.tzfa = tzfa;
        this.avgDay = avgDay;
        this.bld = bld;
        this.bbd = bbd;
        this.bbdzyl = bbdzyl;
        this.aqbj = aqbj;
    }
}
