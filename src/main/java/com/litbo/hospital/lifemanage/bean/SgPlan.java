package com.litbo.hospital.lifemanage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
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
     * 制定人 接收为制定人id 返回为制定人名字
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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date planDate;
}