package com.litbo.hospital.lifemanage.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * LcclToVO
 *
 * @author Administrator on 2019-04-10
 */
@Data
public class LcclToVO {
    /**
     * 处置申请id
     */
    private String id;
    /**
     * 设备编号
     */
    private String eqSbbh;
    /**
     * 设备名称
     */
    private String eqName;
    /**
     * 型号
     */
    private String eqXh;
    /**
     * 规格
     */
    private String eqGg;
    /**
     * 采购日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date eqCgrq;
    /**
     * 设备价格
     */
    private String eqPrice;
    /**
     * 院内编号 资产编号
     */
    private String eqZcbh;
    /**
     * 启用日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date eqQysj;
    /**
     * 申报人
     */
    private String userId;
    /**
     * 申报时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date declareTime;
    /**
     * 处置方式
     */
    private String mode;

    /**
     * 上报人
     */
    private String reportPerson;

    /**
     * 上报时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date reportTime;
    /**
     * 审批人
     */
    private String approver;
    /**
     * 批复人
     */
    private String ratify;

    /**
     * 批复时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ratifyTime;

    /**
     * 清理人
     */
    private String clearPerson;

    /**
     * 清理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date clearTime;

    /**
     * 设备去处
     */
    private String sbqc;

    /**
     * 单位领导意见 上报意见
     */
    private String opinion;
    /**
     * 单位领导意见  批复意见
     */
    private String opinion2;

    /**
     * 备案人
     */
    private String record;

    /**
     * 备案时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date recordTime;

    /**
     * 存放位置
     */
    private String storageLocation;

    /**
     * 状态
     */
    private String state;

    /**
     * 是否通过审核
     */
    private String issh;
}
