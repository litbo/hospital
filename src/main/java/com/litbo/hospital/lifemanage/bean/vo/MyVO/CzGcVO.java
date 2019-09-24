package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CzGcVO {
    private String czGcZpjjd;

    private String id;

    private String eqSbbh;

    private String czGcMc;

    private String gcUrl;

    private String czGcNr;

    private String czGcNgr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date czGcNgrq;

    private String czGcShr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date czGcShrq;

    private String czGcShyj;

    private String czGcLb;

    private String czGcZys;

    private String bmId;
    private String bmName;

    private String czGcBbh;

    private String czGcZpjsqr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date czGcZpjSqrq;

    private String czGcZpjShr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date czGcSxrq;

    private String czGcZt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date czGcZpsShrq;

    private String czGcZpjyy;

    private String czGcZpjShjg;

    private String czGcNrdxg;

    private String czGcZysdxg;

    private String czGcBbhdxg;

    private Integer czGcSyts;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date czGcBakssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date czGcQykssj;

    private String czGcZpjShyj;


    private String shlx;
    private String eqPmName;
    private String eqPp;
    private String eqGg;
    private String eqXh;
    private String eqName;

}
