package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 待报废清单VO
 *
 * @author Administrator on 2018-12-19
 */
@Data
public class ScrappedListVO {
    /**
     * 设备id
     */
    private String eqId;
    /**
     * 设备编号
     */
    private String eqSbbh;
    /**
     * 设备名字
     */
    private String eqName;
    /**
     * 部门名字
     */
    private String bmName;
    /**
     * 设备规格
     */
    private String eqGg;
    /**
     * 设备型号
     */
    private String eqXh;
    /**
     * 单价
     */
    private BigDecimal eqPrice;
}
