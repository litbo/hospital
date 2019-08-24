package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

@Data
public class SgPdJg {
    /**
     *盘点结果号
     */
    private String pdJgid;
    /**
     *盘点流水号
     */
    private String pdId;
    /**
     *该科室所有的品名id
     */
    private Integer pdPmId;
    /**
     *该科室所有的资产编号
     */
    private String pdZcId;
    /**
     *盘点完成时间
     */
    private Date pdWcsj;
    /**
     *单个数据盘点状态
     */
    private Integer pdZt;
}