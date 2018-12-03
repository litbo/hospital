package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

/**
 * 临时采购授权表实体类
 */
@Data
public class SgLssq {
    private String lssqId;

    private String lssqSqr;

    private String lssqBsqks;

    private Date lssqSqrq;

    private Date lssqKsrq;

    private Date lssqJsrq;

    private String extendOne;

    private String extendTwo;
}