package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 论证分析参考型号及报价表实体类
 */
@Data
public class SgLzfxxhbj {
    /**
     * 主键
     */
    private String xhbjId;
    /**
     * 论证分析id
     */
    private String lzfxId;
    /**
     * 设备厂商id
     */
    private Integer sbcsId;
    /**
     * 型号
     */
    private String xhbjXh;
    /**
     * 报价
     */
    private BigDecimal xhbjBj;
    /**
     * 技术参数性能指标
     */
    private String xhbjJszb;
    /**
     * 扩展一
     */
    private String extendOne;
    /**
     * 扩展二
     */
    private String extendTwo;
}