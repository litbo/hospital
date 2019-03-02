package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class SelectFwFpByIdVo {
    private Integer id;
    private String fpDh;
    private String djrName;
    private String fpHm;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date fpSdTime;
    private BigDecimal fpPrice;
}
