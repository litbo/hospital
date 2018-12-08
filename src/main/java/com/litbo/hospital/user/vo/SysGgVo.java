package com.litbo.hospital.user.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class SysGgVo {

    private Integer id;

    private String gglxName;

    private String bmName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date kssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jssj;

    private String ggbt;

    private String status;

    private String ggnr;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngsj;
}

