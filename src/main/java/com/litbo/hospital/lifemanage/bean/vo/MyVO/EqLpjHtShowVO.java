package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


/*零配件合同展示vo*/
@Data
public class EqLpjHtShowVO {
    public EqLpjHtShowVO(String htYf, String htSbmc, Date htQssj, Date htJssj) {
        this.htYf = htYf;
        this.htSbmc = htSbmc;
        this.htQssj = htQssj;
        this.htJssj = htJssj;
    }

    public EqLpjHtShowVO() {
    }

    /*流水号*/
    private String id;

    /*合同状态*/
    private String htZt;

    /*乙方/供货商*/
    private String htYf;

    /*乙方名字*/
    private String htYfName;

    /*设备名称*/
    private String htSbmc;

    /*设备编号*/
    private String htSbbh;

    /*签订日期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date htYfrq;

    /*交货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date htJhsj;

    /*查询起始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date htQssj;


    /*查询结束时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date htJssj;


    /*成交金额(保留整数)*/
    private BigDecimal htCjje;

    /*零配件汇总*/
    private String htLpjhz;


}
