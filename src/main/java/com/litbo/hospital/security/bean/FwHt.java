package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwHt {
    private String id;

    private String htName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date htTime;

    private String htLx;

    private BigDecimal htPrice;

    private Integer sbcsId;

    private String heWxsdb;

    private String htYfdb;

    private String htZffs;

    private String htJfly;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date htBxksTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date htBxjsTime;

    private Integer htXyTime;

    private String htBxfw;

    private Integer htHpjf;

    private String htFjurl;

    private Integer eqId;

    private Integer htStatus;

    private String htMs;


}