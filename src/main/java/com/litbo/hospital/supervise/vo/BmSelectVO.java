package com.litbo.hospital.supervise.vo;

public class BmSelectVO {
    private String bmName;   //部门名称关键词
    private String bmlb;    //部门类别
    private String gklb;    //归口类别
    private String isWx;   //是否维修

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = "%"+bmName+"%";
    }

    public String getBmlb() {
        return bmlb;
    }

    public void setBmlb(String bmlb) {
        this.bmlb = bmlb+"%";
    }

    public String getGklb() {
        return gklb;
    }

    public void setGklb(String gklb) {
        this.gklb = gklb+"%";
    }

    public String getIsWx() {
        return isWx;
    }

    public void setIsWx(String isWx) {
        this.isWx = isWx;
    }
}
