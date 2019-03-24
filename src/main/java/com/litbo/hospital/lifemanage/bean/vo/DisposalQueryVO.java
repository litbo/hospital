package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 处置查询列表
 *
 * @author Administrator on 2018-12-19
 */
@Data
public class DisposalQueryVO {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date eqCgrq;
    /**
     * 单价
     */
    private BigDecimal eqPrice;
    /**
     * 申报人姓名
     */
    private String userName;

    /**
     * 申报时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date declareTime;
    /**
     * 上报时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date reportTime;
    /**
     * 批复时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date ratifyTime;
    /**
     * 状态
     */
    private String state;
}
