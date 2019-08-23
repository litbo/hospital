package com.litbo.hospital.lifemanage.bean.MyBean;

import lombok.Data;

import java.util.Date;

/*装备调剂申请*/
@Data
public class EqTjsq {

    /*主键*/
    private String id;

    /*申请科室*/
    private String tjSqks;

    /*调配/替换装备名称(可多个)*/
    private String tjZbmc;

    /*调配日期*/
    private Date tjTprq;

    /*申请理由*/
    private String tjSqly;

    /*调入经办人(登陆人)*/
    private String tjDrjbr;

    /*申请时间*/
    private Date tjSqsj;

    /*申请调配过程*/
    private String tjSqtpgc;

    /*申请类型(0调配/1应急替换)*/
    private String tjSqlx;

    /*性质(是否演练，仅调剂使用)*/
    private String tjSfyl;

    /*应急替换申请状态(紧急报停(成功/失败),
    科室搜查(未查找到可用设备,查找到可用设备),
    设备替代(成功/失败))
    */
    private String tjSqzt;

    /*查找结果(未查找到可用设备,成功,失败查找到可用设备)*/
    private String tjCzjg;

    /*调配单状态（已送达，未送达）*/
    private String tjDpdzt;

    /*调入科室签字图片*/
    private String  tjDrksurl;

    /*指挥长*/
    private String tjZhz;

    /*是否全部受理*/
    private String tjSfqbsl;
}