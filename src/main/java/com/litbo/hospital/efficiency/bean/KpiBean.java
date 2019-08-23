package com.litbo.hospital.efficiency.bean;

import lombok.Data;

/**
 * description: kpi操作数据库
 * @author: sz
 * @date: 2019/8/3 11:24
 */
@Data
public class KpiBean {
    /** 设备编号 */
    private String eqCode;

    /** 设备名称 */
    private String eqName;

    /** kpi对应的比率 */
    private String ratio;

    /** 排名 */
    private Integer ranking;

    /** 时间 */
    private String times;

    /** 类型 */
    private String status;

    /** 比率类型 */
    private String dataStatus;
}
