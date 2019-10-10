package com.litbo.hospital.lifemanage.bean;

public class SelectVO {

    private String eqSbbh;
    private String eqName;
    private String bmName;

    @Override
    public String toString() {
        return "SelectVO{" +
                "eqSbbh='" + eqSbbh + '\'' +
                ", eqName='" + eqName + '\'' +
                ", bmName='" + bmName + '\'' +
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

        @Override
        public boolean equals(Object obj) {
            if(eqName.equals(((SelectVO)obj).getEqName()))
                return true;//这里以name为判定标准。
            else {
                return false;
            }

    }




}
