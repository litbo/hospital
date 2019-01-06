package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ListFwFpByWaitExamineVo {

    private Integer id;

    private String fpDh;

    private BigDecimal fpPrice;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date fpSdTime;

    private String userName;

    private String eqName;

    private String fpHm;


}
