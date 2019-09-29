package com.litbo.hospital.supervise.vo;

public class WxbmSzSelectVO {
//    科室名称	科室编号	拼音码	科室类别	管理科室类别	是否维修科室
    private String bmName;
    private String bmId;
    private String pym;
    private String bmLb;
    private String glBmLb;
    private String isWxbm;

    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = bmName;
    }

    public String getBmId() {
        return bmId;
    }

    public void setBmId(String bmId) {
        this.bmId = bmId;
    }

    public String getPym() {
        return pym;
    }

    public void setPym(String pym) {
        this.pym = pym;
    }

    public String getBmLb() {
        return bmLb;
    }

    public void setBmLb(String bmLb) {
        this.bmLb = bmLb;
    }

    public String getGlBmLb() {
        return glBmLb;
    }

    public void setGlBmLb(String glBmLb) {
        this.glBmLb = glBmLb;
    }

    public String getIsWxbm() {
        return isWxbm;
    }

    public void setIsWxbm(String isWxbm) {
        this.isWxbm = isWxbm;
    }
}
