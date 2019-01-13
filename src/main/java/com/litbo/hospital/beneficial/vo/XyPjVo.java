package com.litbo.hospital.beneficial.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class XyPjVo {
    private String bmName;

    private String eqName;

    private String eqNum;

    private String eqXh;

    private BigDecimal eqPrice;

    private BigDecimal sy;

    private String syl;

    private Date eqQysj;

    private Integer hbq;
}
