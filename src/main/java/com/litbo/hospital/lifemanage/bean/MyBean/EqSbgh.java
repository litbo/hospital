package com.litbo.hospital.lifemanage.bean.MyBean;

import lombok.Data;

import java.util.Date;

@Data
public class EqSbgh {

    /*主键*/
    private String id;

    /*装备编码*/
    private String eqZbbm;

    /*装备数量*/
    private Integer eqCount;

    /*归还日期*/
    private Date eqGhrq;

    /*装备检查*/
    private String eqZbjc;

    /*归还科室*/
    private String eqGhks;

    /*接收科室*/
    private String eqJsks;

    /*归还经办人*/
    private String eqGhjbr;

    /*接收经办人*/
    private String eqJsjbr;

    /*调剂交接id*/
    private String eqDpjjid;

    /*归还类型*/
    private String eqGhlx;

    /*装备调入图片路径*/
    private String eqDrurl;

    /*装备调出图片路径*/
    private String eqDcurl;

}