package com.litbo.hospital.beneficial.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*
* 模糊查询VO
* */
public class CbMhVo {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date kssj;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jssj;

    private String bmNameByx;

    private String eqNameByx;

    public Date getKssj() {
        return kssj;
    }

    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    public Date getJssj() {
        return jssj;
    }

    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    public String getBmNameByx() {
        return bmNameByx;
    }

    public void setBmNameByx(String bmNameByx) {
        this.bmNameByx = '%'+bmNameByx+'%';
    }

    public String getEqNameByx() {
        return eqNameByx;
    }

    public void setEqNameByx(String eqNameByx) {
        this.eqNameByx = '%'+eqNameByx+'%';
    }

}
