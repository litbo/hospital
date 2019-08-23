package com.litbo.hospital.lifemanage.bean.MyBean;

import lombok.Data;

import java.util.Date;

@Data
public class EqTjjj {

    /*主键*/
    private String id;

    /*院内编码*/
    private String tjjjBianma;



    /*数量(所有装备名称的数量)*/
    private Integer tjjjCount;

    /*调配日期*/
    private Date tjjjTprq;

    /*调配时间*/
    private Date tjjjTpsj;

    /*调配过程记录*/
    private String tjjjDpgc;

    /*调配方装备状态检查*/
    private String tjjjDpfztjc;

    /*调配方附件检查*/
    private String tjjjDpffjjc;

    /*调入科室*/
    private String tjjjDrks;

    /*调出科室*/
    private String tjjjDcks;

    /*调入经办人*/
    private String tjjjDrjbr;

    /*调出经办人*/
    private String tjjjDcjbr;

    /*记录类型(0调剂/1申请)*/
    private String tjjjJllx;

    /*装备调出id*/
    private String tjjjZbdcid;

    /*接收日期*/
    private Date tjjjJsrq;

    /*调配时长*/
    private Integer tjjjDpsc;

    /*接收方装备状态检查*/
    private String tjjjJsfztjc;

    /*接收方附件检查*/
    private String tjjjJsffjjc;

    /*装备是否全部到货*/
    private String eqSfqbgh;

    /*装备调出签字图片url*/
    private String tjjjDcurl;

    /*装备调入签字图片url*/
    private String tjjjDrurl;

    /*其他*/
    private String tjjjQita;

}