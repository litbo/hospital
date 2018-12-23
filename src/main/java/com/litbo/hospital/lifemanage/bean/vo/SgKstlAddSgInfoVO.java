package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

/**
 * 填写申购单返回值VO
 */
@Data
public class SgKstlAddSgInfoVO {

    /**
     * 设备品名ID
     */
    private String eqPmId;
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
     * 申购单id
     */
    private String sgInfoId;
    /**
     * 申购单编号
     */
    private String bh;
}