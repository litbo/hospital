package com.litbo.hospital.security.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwFp {
    private Integer id;

    private String fpDh;

    private BigDecimal fpPrice;

    private Date fpSdTime;

    private Integer fpStatus;

    private String userId;

    private Date fpShTime;

    private String shyj;

    private String fpShrId;

    private String fwHm;



}