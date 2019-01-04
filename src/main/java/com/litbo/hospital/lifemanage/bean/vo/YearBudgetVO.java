package com.litbo.hospital.lifemanage.bean.vo;

import lombok.Data;

/**
 * YearBudgetVO 年度预算
 *
 * @author Administrator on 2018-12-11
 */
@Data
public class YearBudgetVO {
    /**
     * 部门id
     */
    private String bmId;
    /**
     * 部门名字
     */
    private String bmName;
    /**
     * 预算总额(元)
     */
    private String ysy;
    /**
     * 预算总额（美元）
     */
    private String ysmy;
}
