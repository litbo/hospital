package com.litbo.hospital.lifemanage.bean.MyBean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.security.bean.FwPjqlZjb;
import com.litbo.hospital.security.bean.FwPjzd;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Blwxbg {
    private String id;

    private String eqId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date bxDqr;

    private String bxksId;
  private String bxksName;
    private String bxr;

    private String bxfs;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date fxsj;

    private String bxzt;

    private String jjx;

    private String bxksdh;

    private String bxrdh;

    private String lrr;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date bxsj;

    private String ygztj;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date slsj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ydwxsj;
    private List<FwPjzd> fwpjzdlist;
    private String slr;

    private String wxfs;

    private String gzpc;

    private String wxlx;

    private String gzyymx;

    private String wxgznr;

    private String fzwxry;

    private String ywwxgcs;

    private String rgfcjj;

    private String wxgs;

    private String wxjg;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date fwkssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date pcwcsj;

    private String gzyylx;

    private String gzbw;

    private String wxgcs;

    private String wxzd;

    private String rgfbj;

    private String zdzxrc;

    private String gztjsc;

    private String gcsjy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date fwjssj;

    private String wxpj;

    private String wxs;

    private String wxslxdh;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date wxtzsj;
    private List<FwPjqlZjb> pjlist;
    private String wxslxr;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date yyddsj;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date qrsj;

    private String qrjg;

    private String qrr;

    private String myd;

    private String gznr;

   }