package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class FwBaoxiu {
    private String id;

    private String eqId;

    private String bxrId;

    private String bxfs;

    private String bxrdh;

    private String bxksId;

    private String bxksdh;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bxTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fxTime;

    private Integer jjxStatus;

    private Integer bxStatus;

    private String gzxx;

    private Integer zzStatus;

    private Date zzTime;


}