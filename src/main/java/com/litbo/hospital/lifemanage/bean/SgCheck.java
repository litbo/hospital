package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

/**
 * 账实核对
 */
@Data
public class SgCheck {
    /**
     * 主键
     */
    private String id;

    /**
     * 设备id
     */
    private String eqId;

    /**
     * 审核日期
     */
    private Date date;

    /**
     * 审核人
     */
    private String userId;

    /**
     * 是否存在
     */
    private String checks;

    /**
     * 计划id
     */
    private String planId;
}