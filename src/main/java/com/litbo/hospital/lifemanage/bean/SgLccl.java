package com.litbo.hospital.lifemanage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 处置管理实体
 */
@Data
public class SgLccl {
    /**
     * 主键
     */
    private String id;

    /**
     * 单据号
     */
    private String lcclId;

    /**
     * 设备id
     */
    private String eqId;

    /**
     * 申报人id
     */
    private String userId;

    /**
     * 申报时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
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
     * 单位领导意见
     */
    private String opinion;

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