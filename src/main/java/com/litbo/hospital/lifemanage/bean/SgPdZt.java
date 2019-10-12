package com.litbo.hospital.lifemanage.bean;

public class SgPdZt {
    String eqSbbh;
    String eqName;
    String bmName;
    String pdZt;
    String pdJhid;

    @Override
    public String toString() {
        return "SgPdZt{" +
                "eqSbbh='" + eqSbbh + '\'' +
                ", eqName='" + eqName + '\'' +
                ", bmName='" + bmName + '\'' +
                ", pdZt='" + pdZt + '\'' +
                ", pdJhid='" + pdJhid + '\'' +
                '}';
    }

    public String getEqSbbh() {
        return eqSbbh;
    }

    public void setEqSbbh(String eqSbbh) {
        this.eqSbbh = eqSbbh;
    }

    public String getEqName() {
        return eqName;
    }

    public void setEqName(String eqName) {
        this.eqName = eqName;
    }

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getPdZt() {
        return pdZt;
    }

    public void setPdZt(String pdZt) {
        this.pdZt = pdZt;
    }

    public String getPdJhid() {
        return pdJhid;
    }

    public void setPdJhid(String pdJhid) {
        this.pdJhid = pdJhid;
    }
}
