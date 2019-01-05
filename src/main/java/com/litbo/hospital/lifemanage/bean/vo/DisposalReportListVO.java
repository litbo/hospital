package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 处置上报VO
 *
 * @author Administrator on 2018-12-29
 */
@Data
public class DisposalReportListVO {
    /**
     * 设备id
     */
    private String eqId;
    /**
     * 设备编号
     */
    private String eqSbbh;
    /**
     * 设备名字
     */
    private String eqName;
    /**
     * 部门名字
     */
    private String bmName;
    /**
     * 设备规格
     */
    private String eqGg;
    /**
     * 设备型号
     */
    private String eqXh;
    /**
     * 采购日期
     */
    private Date eqCgrq;
    /**
     * 单价
     */
    private BigDecimal eqPrice;
    /**
     * 申报人
     */
    private String userName;
    /**
     * 申报时间
     */
    private Date declareTime;
    /**
     * 单位领导意见
     */
    private String opinion;
    /**
     * 处置方式
     */
    private String mode;
}
