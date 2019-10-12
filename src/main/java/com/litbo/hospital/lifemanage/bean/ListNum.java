package com.litbo.hospital.lifemanage.bean;

public class ListNum {
    private Integer allNum;
    private  Integer yiPanNum;
    private Integer panYingNum;
    private Integer panKuiNum;

    @Override
    public String toString() {
        return "ListNum{" +
                "allNum=" + allNum +
                ", yiPanNum=" + yiPanNum +
                ", panYingNum=" + panYingNum +
                ", panKuiNum=" + panKuiNum +
                '}';
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    public Integer getYiPanNum() {
        return yiPanNum;
    }

    public void setYiPanNum(Integer yiPanNum) {
        this.yiPanNum = yiPanNum;
    }

    public Integer getPanYingNum() {
        return panYingNum;
    }

    public void setPanYingNum(Integer panYingNum) {
        this.panYingNum = panYingNum;
    }

    public Integer getPanKuiNum() {
        return panKuiNum;
    }

    public void setPanKuiNum(Integer panKuiNum) {
        this.panKuiNum = panKuiNum;
    }
}
