package com.litbo.hospital.beneficial.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class XyPjVo {
    private String bmName;

    private String eqName;

    private String eqNum;
    /*诊疗次数*/
    private String zlcs;

    private String eqXh;
    private String eqGg;
    private String eqGgxh;
    /*期间收入*/
    private String qjsr;
    /*期间支出*/
    private String qjzc;


    /*原价*/
    private BigDecimal eqPrice;
    /*期间收益*/
    private BigDecimal qjsy;
    /*年化收益*/
    private BigDecimal nhsy;
    /*年化收益率*/
    private String nhsyl;
    /*收益率*/
    private String syl;
    /*启用时间*/
    private Date eqQysj;
    /*回本期*/
    private Integer hbq;
}
