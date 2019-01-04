package com.litbo.hospital.security.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zjc
 * @create 2018-12-10 11:22
 */
@Data
public class FwInfoVo {

    private String eqId;

    private String eqName;

    private String bxrId;

    private String bxrName;

    private String slrId;

    private String slrName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ydwxTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bxTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date slTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fwksTime;

    private String wxrName;

    private String gzyy;

    private String gzmx;


}
