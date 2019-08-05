package com.litbo.hospital.security.specialequipment.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SpecialEquipmentRecordVo {


    private String speqBh;

    private String speqJczbh;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqJcsj;

    private String speqSjsqr;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqSjsqsj;

    private String speqSjspr;

    @DateTimeFormat( pattern = "yyy-MM-dd")
    @JsonFormat( pattern = "yyy-MM-dd")
    private Date speqSjspsj;

    private Integer speqRun;
}
