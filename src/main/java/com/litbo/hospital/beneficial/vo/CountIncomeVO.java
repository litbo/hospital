package com.litbo.hospital.beneficial.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 汇总HIS、Hacs、手术室的收入
 * @author 48885
 */
@Data
public class CountIncomeVO {

    /** 科室id */
    private String ksId;
    /** 设备id */
    private String sbId;
    /** 科目录入时间 */
    private String kmSj;
    /** 科目编号 */
    private String kmNum;
    /** 科目名字 */
    private String kmName;
    /** 科目金额 */
    private BigDecimal keJe;
    /** 科目收入类型 */
    private String kmCjdm;
    /** 科室名称 */
    private String bmName;
    /** 设备名称 */
    private String eqName;

}
