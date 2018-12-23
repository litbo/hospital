package com.litbo.hospital.beneficial.vo;

import lombok.Data;

import java.math.BigDecimal;
/*
 * 收入VO
 * */
@Data
public class SrVo {
    private String bmName;

    private String eqName;

    private String eqNum;

    private String eqXh;

    private BigDecimal mzsr;

    private BigDecimal kjxmsr;

    private BigDecimal zysr;

    private BigDecimal qt;

    private BigDecimal zj;
}
