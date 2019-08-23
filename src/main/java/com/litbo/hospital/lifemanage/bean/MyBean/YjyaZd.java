package com.litbo.hospital.lifemanage.bean.MyBean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*应急预案制定*/
@Data
public class YjyaZd {

    private String yjyaBh;

    private String yjyaName;

    private String yjyaLx;

    private Integer yjyaZys;

    private String yjyaBbh;

    private String yjyaNgr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaNgrq;

    private String yjyaFbbm;

    private String yjyaNr;

    private String yjyaShr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaShrq;

    private String yjyaShyj;

    private Integer yjyaSyts;

    private String yjyaZt;

    private String yjyaZpjsqr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaZpjsqrq;

    private String yjyaZpjyy;

    private String yjyaZpjsshr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaZpjshrq;

    private String yjyaZpjjg;

    private String yjyaZpjyj;

   }