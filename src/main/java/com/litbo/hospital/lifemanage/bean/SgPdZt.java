package com.litbo.hospital.lifemanage.bean;

public class SgPdZt {
    String eqBh;
    String eqName;
    String bmName;
    String pdZt;
    String pdJhid;

    @Override
    public String toString() {
        return "SgPdZt{" +
                "eqBh='" + eqBh + '\'' +
                ", eqName='" + eqName + '\'' +
                ", bmName='" + bmName + '\'' +
                ", pdZt='" + pdZt + '\'' +
                ", pdJhid='" + pdJhid + '\'' +
                '}';
    }

    public String getEqBh() {
        return eqBh;
    }

    public void setEqBh(String eqBh) {
        this.eqBh = eqBh;
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
