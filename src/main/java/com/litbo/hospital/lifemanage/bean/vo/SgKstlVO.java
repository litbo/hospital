package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

/**
 * 申购单表实体类
 */
@Data
public class SgKstlVO {

    /**
     * 设备品名ID
     */
    private Integer eqPmId;
    /**
     * 设备品名
     */
    private String eqPmName;
    /**
     * 设备简称
     */
    private String eqPmJc;
    /**
     * 卫标分类编号
     */
    private Integer eqFlId;
    /**
     * 卫标分类名称
     */
    private String eqFlName;
    /**
     * 申购单编号
     */
    private String bh;
}