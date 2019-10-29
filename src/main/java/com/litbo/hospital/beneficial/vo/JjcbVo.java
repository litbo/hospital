package com.litbo.hospital.beneficial.vo;

import lombok.Data;

import java.math.BigDecimal;
/*
* 间接成本VO
* */
@Data
public class JjcbVo {
    private String bmName;

    private String eqName;

    private String eqNum;

    private String eqXh;

    private BigDecimal glfy;
    private BigDecimal qt;

    private BigDecimal fzkscb;

    private BigDecimal zj;
}
