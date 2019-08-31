package com.litbo.hospital.lifemanage.bean.MyBean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.EqLpjHtZbVO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 零配件合同
 * */
@Data
public class EqLpjht {

    public EqLpjht() {
        this.htZt = "0";

    }

    /*（主键）*/
    private String id;

    /*假合同Id*/
    private String htJhtid;

    /*甲方*/
    private String htJf;

    /*乙方*/
    private String htYf;

    /*乙方名字*/

    private String htYfName;
    /*保修期(月)*/
    private Integer htBxq;

    /*交货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date htJhsj;

    /*设备名称*/
    private String htSbmc;

    /*设备编号*/
    private String htSbbh;

    /*故障描述*/
    private String htGzms;

    /*故障分析*/
    private String htGzfx;

    /*配件名称(配件可以购买多个)*/
    private String htPjmc;

    /*规格型号*/
    private String htGgxh;

    /*数量*/
    private Integer htCount;

    /*报价*/
    private BigDecimal htBj;

    /*优惠价*/
    private BigDecimal htYhj;

    /*总价*/
    private BigDecimal htZj;

    /*成交金额(保留整数)*/
    private BigDecimal htCjje;

    /*甲方日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date htJfrq;

    /*乙方电话*/
    private String htYfdh;

    /*乙方开户行账号*/
    private String htKhhzh;

    /*乙方日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date htYfrq;

    /*设备编号(可选可不选)*/
    private String sbbh;

    /*合同状态 （0已签订 1执行中 2已完成）*/
    private String htZt;

    /*零配件汇总*/
    private String htLpjhz;

    private List<EqLpjHtZbVO> listLpj = new ArrayList<>();


}