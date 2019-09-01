package com.litbo.hospital.beneficial.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*
* 模糊查询VO
* */
@Data
public class CbMhVo {

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private String kssj;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private String jssj;

    private String bmNameByx;

    private String eqNameByx;

//    public Date getKssj() {
//        return kssj;
//    }
//
//    public void setKssj(Date kssj) {
//        this.kssj = kssj;
//    }
//
//    public Date getJssj() {
//        return jssj;
//    }
//
//    public void setJssj(Date jssj) {
//        this.jssj = jssj;
//    }
//
//    public String getBmNameByx() {
//        return bmNameByx;
//    }
//
//    public void setBmNameByx(String bmNameByx) {
//        this.bmNameByx = bmNameByx;
//    }
//
//    public String getEqNameByx() {
//        return eqNameByx;
//    }
//
//    public void setEqNameByx(String eqNameByx) {
//        this.eqNameByx = eqNameByx;
//    }

}
