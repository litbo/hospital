package com.litbo.hospital.security.bean;

import lombok.Data;

import java.util.Date;
@Data
public class FwBaoxiu {
    private String id;

    private Integer eqId;

    private String bxrId;

    private String bxfs;

    private String bxrdh;

    private String bxks;

    private String bxksdh;

    private Date bxTime;

    private Date fxTime;

    private Integer jjxStatus;

    private Integer bxStatus;

    private Integer gzxx;

    private Integer zzStatus;

    private Date zzTime;


}