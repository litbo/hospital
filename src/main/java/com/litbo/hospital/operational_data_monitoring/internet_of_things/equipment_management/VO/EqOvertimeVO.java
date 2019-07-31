package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO;

import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.looli.VO
 * @Author: looli
 * @CreateTime: 2019-07-20 18:53
 * @Description: todo
 */
@Data
public class EqOvertimeVO {
    //加班表id
    private String id;

    //设备表
    //设备名称
    private String eqName;
    //设备编号
    private String eqSbbh;
    //设备简称表
    //设备简称
    private String cAName;

    private Date startDate;

    private Date endDate;

    private String startTime;

    private String endTime;
}
