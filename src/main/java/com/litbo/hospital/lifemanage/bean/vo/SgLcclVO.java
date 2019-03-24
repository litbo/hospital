package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * SgLcclVO
 *
 * @author Administrator on 2018-12-19
 */
@Data
public class SgLcclVO {

    /**
     * 单据号
     */
    private String lcclId;

    /**
     * 设备id
     */
    private String eqId;

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
    private Date ratifyTime;

    /**
     * 单位领导意见
     */
    private String opinion;

    /**
     * 清理人
     */
    private String clearPerson;

    /**
     * 清理时间
     */
    private Date clearTime;

    /**
     * 设备去处
     */
    private String sbqc;

    /**
     * 备案人
     */
    private String record;

    /**
     * 备案时间
     */
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
     * 报废原因id列表
     */
    private List<String> reasonIds;
    /**
     * 审核设备ids
     */
    private List<String> ids;
}
