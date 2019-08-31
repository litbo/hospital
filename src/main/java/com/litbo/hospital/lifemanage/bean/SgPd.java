package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

@Data
public class SgPd {
    /**
     *盘点流水号
     */
    private String pdId;
    /**
     *扫描到的编号
     */
    private String pdScanId;
    /**
     *盘点上传时间
     */
    private String pdScsj;
    /**
     *盘点操作人
     */
    private String pdCzr;
    /**
     *本次盘点的科室id
     */
    private String pdBmId;
    /**
     *该科室盘点状态
     */
    private String pdBmzt;
    /**
     *盘点计划id
     */
    private String pdJhid;
    /**
     *盘点完成时间
     */
    private Date pdWcsj;

}