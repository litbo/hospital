package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 申购单表
 */
@Data
public class SgInfo {
    private String id;

    private String bmId;

    private String bh;

    private Integer eqPmId;

    private String tgBmId;

    private Integer gzlbId;

    private Integer zjlyId;

    private Integer syxzId;

    private Integer num;

    private BigDecimal priceWd;

    private BigDecimal priceSn;

    private BigDecimal priceGjY;

    private BigDecimal priceGjMy;

    private String syl;

    private String pjbgId;

    private String kxfxId;

    private String dxzbId;

    private String iskssh;

    private String isyxgccsh;

    private String iszbwyhsh;

    private String zbwyhyj;

    private String zbwyhhyId;

    private String isybghsh;

    private String ybghyj;

    private String ybghhyId;

    private String zt;

    private String extendOne;

    private String extendTwo;

    private String yxgccyj;

    private String gzll;

    private String xxyt;

    private String mdyt;

    private String jxkylcQk;

    private String jbcsyq;

    private String pzxq;
}