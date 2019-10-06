package com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.vo;

import lombok.Data;

/**
 * 实时监视查询条件
 */
@Data
public class SearchOV {
    /**管理类别*/
    private String cEquCate;
    /**科室id*/
    private String bmId;
    /**是否生命支持类*/
    private String cIsLife;
    /**使用状态*/
    private String eqstatus;
    /**完好装态*/
    private String eqsyzt;
    /**设备简称*/
    private String cAName;

}
