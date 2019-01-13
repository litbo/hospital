package com.litbo.hospital.beneficial.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShowSbcwVo {

    private String bmName;

    private String eqName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date kmSj;

    private String kmName;

    private Integer qjlc;

    private BigDecimal kmValue;
}
