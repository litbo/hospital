package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class ListFwYwFp {
    private Integer id;

    private String ywfpHm;

    private BigDecimal ywfpPrice;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ywfpSdTime;

    private String userName;

    private String eqName;

    private String sbcsName;
}
