package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwFp {
    private Integer id;

    private String fpDh;

    private BigDecimal fpPrice;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fpSdTime;

    private Integer fpStatus;

    private String userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fpShTime;

    private String shyj;

    private String fpShrId;

    private String fpHm;



}