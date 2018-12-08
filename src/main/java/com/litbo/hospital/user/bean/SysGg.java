package com.litbo.hospital.user.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class SysGg {
    private Integer id;

    private Integer gglxId;

    private String bmId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date kssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jssj;

    private String ngr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngsj;

    private Integer status;

    private String ggbt;

    private String ggnr;


}