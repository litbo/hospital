package com.litbo.hospital.operational_data_monitoring.software_interface.vo;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.vo
 * @Author: looli
 * @CreateTime: 2019-07-26 09:34
 * @Description: todo
 */
@Data
public class HISCycle {
    /**起始时间*/
    private String beginTime;
    /**结束时间*/
    private String endTime;

//
//    /**当天是哪一天*/
//    private String nowadays;
//    /**周期 从当天往前查几天*/
//    private String days;
//    /**定时*/
//    private String time;
    int begin;
    int end;
}
