package com.litbo.hospital.lifemanage.check.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Equipment {

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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
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
