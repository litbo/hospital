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
    private String eqBxqx;
    /**
     * 保修状态
     */
    private String eqSyzt;

}
