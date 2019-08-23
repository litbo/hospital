package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EqTjjjVO {

    /*主键*/
    private String id;

    /*院内编码*/
    private String tjjjBianma;

    /*装备编码集合*/
    private List<String> listbianma = new ArrayList<>();

    /*设备归还集合*/
    private List<EqSbghZbVO> listsbgh = new ArrayList<>();

    /*装备名称*/
    private String tjjjZbmc;

    /*数量(所有装备名称的数量)*/
    private Integer tjjjCount;

    /*调配日期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjjjTprq;

    /*调配时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjjjJsrq;

    /*调配时长*/
    private Integer tjjjDpsc;

    /*接收方装备状态检查*/
    private String tjjjJsfztjc;

    /*接收方附件检查*/
    private String tjjjJsffjjc;

    /*装备是否全部归还*/
    private String eqSfqbgh;

    /*装备调出签字图片url*/
    private String tjjjDcurl;

    /*装备调入签字图片url*/
    private String tjjjDrurl;

    /*其他*/
    private String tjjjQita;

}
