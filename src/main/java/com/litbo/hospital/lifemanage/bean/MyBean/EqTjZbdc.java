package com.litbo.hospital.lifemanage.bean.MyBean;

import lombok.Data;

import java.util.Date;

/*调剂装备调出*/
@Data
public class EqTjZbdc {

    /*主键*/
    private String id;

    /*申请调剂Id*/
    private String tjSqtj;

    /*调出科室*/
    private String tjDcks;

    /*联系人*/
    private String tjLxr;

    /*调配到位时间*/
    private Date tjDwsj;

    /*装备院内编码*/
    private String tjZbbm;

    /*规格*/
    private String tjGg;

    /*型号*/
    private String tjXh;

    /*调配数量*/
    private Integer tjTpsl;

    /*使用时长*/
    private Integer tjSysc;

    /*装备状态检查*/
    private String tjZbztjc;

    /*附件检查*/
    private String tjFjjc;

    /*调出经办人*/
    private String tjDcjbr;

    /*调配时间*/
    private Date tjDpsj;

    /*调出进度(待调出，已发起调出)*/
    private String tjDcjd;

    /*调出科室签字图片*/
    private String tjDcksurl;

    /*指挥长*/
    private String tjZhz;

    /*调剂申请装备编码*/
    private String tjSqzbbms;

    /*调剂申请装备数量*/
    private String tjSqzbcounts;

    /*调出类型*/
    private String tjDclx;


}
