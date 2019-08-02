package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.looli.VO
 * @Author: looli
 * @CreateTime: 2019-07-21 10:34
 * @Description: todo
 */
@Data
public class ApprovedWorkingHoursVO {
    private String id;

    private String eqMacId;

    private String ratingType;

    private String workDays;

    private String amShift;

    private String pmShift;

    private String fmShift;

    private String fullLoadTime;

    //设备简称表
    //设备简称
    private String cAName;

    //设备表
    //设备名称
    private String eqName;
    //设备编号
    private String eqSbbh;
}
