package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/*装备调出VO*/
@Data
public class EqTjZbdcVO {

    /*主键*/
    private String id;

    /*申请调剂Id*/
    private String tjSqtj;

    /*调出科室*/
    private String tjDcks;

    /*调出科室名字*/
    private String tjDcksName;

    /*联系人*/
    private String tjLxr;

    /*调出经办人*/
    private String tjDcjbr;

    /*调配到位时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tjDwsj;

    /*装备院内编码*/
    private String tjZbbm;

//    /*调剂申请装备的装备编码(删除和修改数量用)*/
//    private String tjZbbm2;

    /*展示调出装备的装备名字*/
    private List<String> tjZbName;


    /*规格*/
    private String tjGg;

    /*型号*/
    private String tjXh;

    /*规格型号*/
    private String tjGgxh;

    /*调配数量*/
    private Integer tjTpsl;

    /*使用时长*/
    private Integer tjSysc;

    /*装备状态检查*/
    private String tjZbztjc;

    /*附件检查*/
    private String tjFjjc;


    /*调配时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tjDpsj;

    /*调出进度*/
    private String tjDcjd;

    /*调剂申请装备的装备名称(删除和修改数量用)*/
    private String zbName;

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
