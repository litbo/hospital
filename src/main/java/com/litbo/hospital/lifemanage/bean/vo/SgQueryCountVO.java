package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

/**
 * SgQueryCount 查询统计实体类
 *
 * @author Administrator on 2019-03-07
 */
@Data
public class SgQueryCountVO {
    /**
     * 设备id
     */
    private String eqId;
    /**
     * 设备编号
     */
    private String eqSbbh;
    /**
     * 院内编号  资产编号
     */
    private String eqZcbh;
    /**
     * 设备名称
     */
    private String eqName;
    /**
     * 规格
     */
    private String eqGg;
    /**
     * 型号
     */
    private String eqXh;
    /**
     * 启用时间
     */
    private String eqQysj;
    /**
     * 设备类别
     */
    private String eqCxflName;
    /**
     * 维修次数
     */
    private String repairTimes;
    /**
     * 累计维修费
     */
    private String repairCosts;
    /**
     * 使用年数
     */
    private String useYears;
    /**
     * 折旧年限
     */
    private String depreciationYears;
    /**
     * 累计折旧额
     */
    private String accumulatedDepreciation;
    /**
     * 资产状态
     */
    private String eqSyzt;
    /**
     * 保修状态
     */
    private String eqBxqx;
    /**
     * 所在科室
     */
    private String bmName;
    /**
     * 托管科室
     */
    private String eqTgks;
    /**
     * 单价
     */
    private String eqPrice;
    /**
     * 生产商
     */
    private String sbcsName;
    /**
     * 采购日期
     */
    private String eqCgrq;
    /**
     * 查询总金额
     */
    private String zje;
}
