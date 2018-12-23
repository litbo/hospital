package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 登记货物表实体类
 */
@Data
public class SgDjhw {
    /**
     * 登记货物表主键
     */
    private String djhwId;
    /**
     * 到货登记表id
     */
    private String dhdjId;
    /**
     * 单位
     */
    private String djhwDw;
    /**
     * 包装箱号
     */
    private Integer djhwBzxh;
    /**
     * 品牌
     */
    private String djhwPp;
    /**
     * 箱内设备
     */
    private String djhwXnsb;
    /**
     * 规格
     */
    private String djhwGg;
    /**
     * 型号
     */
    private String djhwXh;
    /**
     * 数量
     */
    private Integer djhwSl;
    /**
     * 供应商
     */
    private String djhwGys;
    /**
     * 包装 木箱/纸箱
     */
    private String djhwBz;
    /**
     * 体积
     */
    private Double djhwTj;
    /**
     * 包装标识标签
     */
    private String djhwBsbq;
    /**
     * 货物价值
     */
    private BigDecimal djhwHwjz;
    /**
     * 生产厂家/产地
     */
    private String djhwSccj;
    /**
     * 重量
     */
    private Double djhwZl;
    /**
     * 防倾斜运输标识 -》0无1未变色2已变色
     */
    private String djhwYsbs;
    /**
     * 申购单id
     */
    private String sgId;
    /**
     * 科室接收人
     */
    private String userId;
    /**
     * 科室接受时间
     */
    private Date djhwJssj;
}