package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 审核时查询的VO
 */
@Data
public class SgInfoSumAuditListVO {
    /**
     * 申购单id
     */
    private String id;
    /**
     * 申购部门名字
     */
    private String bmName;
    /**
     * 申购编号
     */
    private String bh;
    /**
     * 设备名称
     */
    private String eqPmName;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 估价(元)
     */
    private BigDecimal priceGjY;
}
