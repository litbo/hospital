package com.litbo.hospital.efficiency.vo;

import lombok.Data;

/**
 * description: 每一种kpi的信息
 * @author: sz
 * @date: 2019/8/3 10:28
 */
@Data
public class KpiRankingVO {

    /** 设备编号 */
    private String eqCode;

    /** 设备名称 */
    private String eqName;

    /** kpi对应的比率 */
    private Double ratio;

    /** 本次排名 */
    private Integer ranking;

    /** 上次排名 */
    private Integer oldRanking;

    /** 排名变化 */
    private Integer change;

    /** 类型 */
    private String status;

    /** 比率类型 */
    private String dataStatus;

}
