package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean;

import lombok.Data;

import java.util.Date;

/**
 * 设备加班表
 * @author looli
 */
@Data
public class EqOvertimeTab {
    private String id;

    private String eqMacId;

    private Date startDate = null;

    private Date endDate = null;

    private String startTime;

    private String endTime;
}