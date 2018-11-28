package com.litbo.hospital.security.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwYwfp {
    private Integer id;

    private Integer sbId;

    private String ywfpDw;

    private String ywfpHm;

    private BigDecimal ywfpPrice;

    private Date ywfpSdTime;

    private Date ywfpCjTime;

}