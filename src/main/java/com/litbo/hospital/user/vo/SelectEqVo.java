package com.litbo.hospital.user.vo;

import lombok.Data;

/**
 * 用作模糊查询的参数
 *  在set方法中直接加上模糊查询的标识符
 *  @version :
 * * @author : ljl
**/
public class SelectEqVo {

    private String bmName;
    private String eqPmPym;
    private String eqSbbh;
    private String eqZcbh;


    public String getBmName() {
        return bmName;
    }

    public void setBmName(String bmName) {
        this.bmName = "%"+bmName+"%";
    }

    public String getEqPmPym() {
        return eqPmPym;
    }

    public void setEqPmPym(String eqPmPym) {
        this.eqPmPym = "%"+eqPmPym+"%";
    }

    public String getEqSbbh() {
        return eqSbbh;
    }

    public void setEqSbbh(String eqSbbh) {
        this.eqSbbh = "%"+eqSbbh+"%";
    }

    public String getEqZcbh() {
        return eqZcbh;
    }

    public void setEqZcbh(String eqZcbh) {
        this.eqZcbh = "%"+eqZcbh+"%";
    }
}
