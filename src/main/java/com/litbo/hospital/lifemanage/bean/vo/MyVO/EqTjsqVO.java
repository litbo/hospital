package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EqTjsqVO {

    /*主键*/
    private String id;

    /*调剂申请科室*/
    private String tjSqks;

    /*调剂申请科室名字*/
    private String bmName;

    /*装备名称*/
    private String tjZbmc;

    /*装备名称集合*/
    List<TjZbMcNameCount> zbmclist=new ArrayList<>();

    /*申请理由*/
    private String tjSqly;

    /*调入经办人(登陆人)*/
    private String tjDrjbr;

    /*申请时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjSqsj;

    /*申请调配过程*/
    private String tjSqtpgc;

    /*申请类型(0调配/1应急替换)*/
    private String tjSqlx;

    /*性质(是否演练，仅调剂使用)*/
    private String tjSfyl;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjTprq;

    /*
    应急替换申请状态(紧急报停(成功/失败),
   科室搜查(未查询到可用设备,查询到可用设备),
   设备替代(成功/失败))
   */
    private String tjSqzt;

    /*查询结果(未查询到可用设备,成功,失败,查询到可用设备)*/
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
