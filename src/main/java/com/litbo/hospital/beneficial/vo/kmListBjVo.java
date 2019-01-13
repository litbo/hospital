package com.litbo.hospital.beneficial.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/*
*
* 单个设备成本科目列表
* */
@Data
public class kmListBjVo {

    private String eqName;

    private String kmName;

    private BigDecimal kmValue;

    private Date kmSj;

    private Integer id;
}
