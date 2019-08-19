package com.litbo.hospital.security.specialequipment.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SpecialEquipment {
    private String speqId;

    private String speqBh;

    private String speqName;

    private String bmId;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqJcsj;

    private Integer speqJczq;

    private String speqGgxh;

    private String speqScs;

    private String speqCcbh;

    private String speqJczbh;

    private String speqZczbh;

    private String speqSyzbh;

    private String speqBz;

    private String aqfjJddj;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqJhjcrq;

    private String speqSjsqr;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqSjsqsj;

    private Integer speqSjsq;

    private String speqSjspr;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqSjspsj;

    private Integer speqSjsp;

    private Integer speqRun;

    private Integer speqType;

    //特种设备单价
    private String speqSpare1;

    private String speqSpare2;

    private String speqSpare3;

    private String speqSpare4;

    private String speqSpare5;


}