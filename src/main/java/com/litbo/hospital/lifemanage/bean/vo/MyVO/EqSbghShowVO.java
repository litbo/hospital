package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import lombok.Data;

import java.util.Date;

@Data
public class EqSbghShowVO {

    /*主键*/
    private String id;

    /*归还装备数量*/
    private Integer eqCount;

    /*归还日期*/
    private Date eqGhrq;

    /*归还科室*/
    private String eqGhks;
    private String eqGhksName;


    /*接收科室*/
    private String eqJsks;
    private String eqJsksName;

    private   String eqGhlx;


}
