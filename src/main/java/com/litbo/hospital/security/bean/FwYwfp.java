package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwYwfp {
    private Integer id;

    private String eqId;

    private String sbcsId;

    private String ywfpHm;

    private BigDecimal ywfpPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ywfpSdTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ywfpCjTime;

}