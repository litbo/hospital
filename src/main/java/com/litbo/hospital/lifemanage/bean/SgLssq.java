package com.litbo.hospital.lifemanage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 临时采购授权表实体类
 */
@Data
public class SgLssq {
    /**
     * 临时授权id
     */
    private String lssqId;
    /**
     * 临时授权人
     */
    private String lssqSqr;
    /**
     * 被授权科室
     */
    private String lssqBsqks;
    /**
     * 授权日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date lssqSqrq;
    /**
     * 授权开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date lssqKsrq;
    /**
     * 授权结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date lssqJsrq;
    /**
     * 扩展一
     */
    private String extendOne;
    /**
     * 扩展二
     */
    private String extendTwo;
}