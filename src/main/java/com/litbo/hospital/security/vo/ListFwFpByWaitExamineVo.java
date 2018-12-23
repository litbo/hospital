package com.litbo.hospital.security.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ListFwFpByWaitExamineVo {

    private Integer id;

    private String fpDh;

    private BigDecimal fpPrice;

    private Date fpSdTime;

    private String userName;

    private String eqName;

}
