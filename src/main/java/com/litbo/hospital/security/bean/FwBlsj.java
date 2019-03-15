package com.litbo.hospital.security.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class FwBlsj {
    private Integer id;

    private Integer eqId;

    private String userId;

    private String bgbh;

    private String bgmc;

    private String bgrgw;

    private String sjxz;

    private String bgrqz;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bgTime;

    private String hzxm;

    private Integer hzAge;

    private String hzSex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sjfsTime;

    private String sjhg;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fxzxTime;

    private String ylqxsxcs;

    private String czry;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zrTime;

    private String bxdh;

    private String yqzlxg;

    private String qxgz;

    private String zysh;

    private String sjcs;

    private String lxdh;


}