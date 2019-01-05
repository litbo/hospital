package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

/**
 * 核对计划
 */
@Data
public class SgPlan {
    /**
     * 主键
     */
    private String id;

    /**
     * 制定人
     */
    private String userId;

    /**
     * 科室id
     */
    private String bmId;

    /**
     * 计划名称
     */
    private String planName;

    /**
     * 计划时间
     */
    private Date planDate;
}