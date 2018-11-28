package com.litbo.hospital.security.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwHt {
    private String id;

    private String htName;

    private Date htTime;

    private String htLx;

    private BigDecimal htPrice;

    private Integer wxsId;

    private String heWxsdb;

    private String htYfdb;

    private String htZffs;

    private String htJfly;

    private Date htBxksTime;

    private Date htBxjsTime;

    private Date htXyTime;

    private String htBxfw;

    private Integer htHpjf;

    private String htFjurl;

    private Integer sbId;

    private Integer htStatus;

    private String htMs;


}