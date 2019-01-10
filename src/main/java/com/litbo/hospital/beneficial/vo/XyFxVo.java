package com.litbo.hospital.beneficial.vo;

import lombok.Data;

import java.math.BigDecimal;

/*
* 效益分析VO
* */

@Data
public class XyFxVo {
    private String bmName;

    private String eqName;

    private String eqNum;

    private String eqXh;

    private BigDecimal sr;

    private BigDecimal cb;

    private BigDecimal sy;

    private int qjlc;

    private BigDecimal zcsr;

    private BigDecimal zccb;

    private BigDecimal zcsy;

}
