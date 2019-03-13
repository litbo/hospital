package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SelectFwBlsjById {
    private Integer id;

    private String eqName;

    private String userXm;

    private String bgbh;

    private String bgmc;

    private String bgrgw;

    private String sjxz;

    private String bgrqz;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date bgTime;

    private String hzxm;

    private Integer hzAge;

    private String hzSex;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date sjfsTime;

    private String sjhg;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date fxzxTime;

    private String ylqxsxcs;

    private String czry;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date zrTime;

    private String bxdh;

    private String yqzlxg;

    private String qxgz;

    private String zysh;

    private String sjcs;

    private String lxdh;


}