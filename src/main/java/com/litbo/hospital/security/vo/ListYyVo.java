package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class ListYyVo {
    private Integer id;

    private String eqName;

    private String pxbh;

    private String eqZcbh;

    private String eqSbbh;

    private String bmName;

    private String ksId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String kstime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String jstime;

    private String pxlx;

    private String pxnr;
}
