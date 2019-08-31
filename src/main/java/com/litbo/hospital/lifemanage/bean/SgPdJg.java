package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

@Data
public class SgPdJg {
    /**
     *盘点结果号
     */
    private String pdJgId;
    /**
     *盘点流水号
     */
    private String pdId;
    /**
     *该科室所有的品名id
     */
    private String pdSbId;
    /**
     *该科室所有的资产编号
     */
    private String pdZcId;
    /**
     *盘点完成时间
     */
    private Date pdWcsj;
    /**
     *科室盘点状态
     */
    private String pdBmzt;
}