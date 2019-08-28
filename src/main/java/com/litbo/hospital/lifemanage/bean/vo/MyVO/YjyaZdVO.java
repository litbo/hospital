package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*应急预案制定*/
@Data
public class YjyaZdVO {


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

    private String yjyaZpjshr;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yjyaZpjshrq;

    private String yjyaZpjjg;

    private String yjyaZpjyj;

    private String yjyaZysdxg;

    private String yjyaNrdxg;

    private String yjyaBbhdxg;



    /*引入辅助字段，判断为再评价审核还是普通审核*/

    private String shlx;
   }