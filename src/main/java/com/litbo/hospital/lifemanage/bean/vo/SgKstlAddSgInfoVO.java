package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

/**
 * 填写申购单返回值VO
 */
@Data
public class SgKstlAddSgInfoVO {
    /**
     * 申购单id
     */
    private String sgInfoId;
    /**
     * 设备品名
     */
    private String eqPmName;
    /**
     * 设备简称
     */
    private String eqPmJc;
    /**
     * 卫标分类
     */
    private String eqFlId;
    /**
     * 设备品名ID
     */
    private String eqPmId;
    /**
     * 申购单编号
     */
    private String bh;
}