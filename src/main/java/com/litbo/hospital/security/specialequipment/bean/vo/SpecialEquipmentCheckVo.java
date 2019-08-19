package com.litbo.hospital.security.specialequipment.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Data
public class SpecialEquipmentCheckVo {

    private String speqId;
    //编号
    private String speqBh;
    //名称
    private String speqName;
    //规格型号
    private String speqGgxh;
    //生产厂商
    private String speqScs;
    //科室名称
    private String bmId;
    //计划检测日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date speqJhjcrq;


}
