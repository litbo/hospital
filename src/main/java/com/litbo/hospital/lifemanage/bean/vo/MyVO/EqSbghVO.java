package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EqSbghVO {

    /*主键*/
    private String id;

    /*装备编码*/
    private String eqZbbm;

    /*装备编码集合*/
    private List<String> zbbmlist = new ArrayList<>();

    /*展示的数据（装备名称，规格,型号，装备编码）*/
    private List<EqSbghZbVO> asdlist = new ArrayList<>();

    /*装备数量*/
    private Integer eqCount;

    /*归还日期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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


