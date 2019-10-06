package com.litbo.hospital.lifemanage.bean.vo.MyVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/*合同展示vo*/
@Data
public class EqHtShowVO {
    public EqHtShowVO(String htYf,String htZt, String htBianhao, Date htQssj, Date htJssj) {
        this.htZt = htZt;
        this.htBianhao = htBianhao;
        this.htYf = htYf;
        this.htQssj = htQssj;
        this.htJssj = htJssj;
    }

    public EqHtShowVO() {
    }

    /*主键*/
    private String id;

    /*合同状态*/
    private String htZt;

    /*合同编号*/
    private String htBianhao;

    /*供货商*/
    private String htYf;

    /*供货商名字*/
    private String htYfName;

    /*设备品名*/
    private String htZbmc;

    /*规格型号*/
    private String htGgxh;

    /*数量*/
    private Integer htCount;

    /*单价*/
    private BigDecimal htDanjia;

    /*装备汇总*/
    private String htZbHz;

    /*成交金额*/
    private BigDecimal htCjje;


    /*签订日期*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date htYfrq;

    /*查询起始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date htQssj;

    /*查询结束时间*/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date htJssj;



}
