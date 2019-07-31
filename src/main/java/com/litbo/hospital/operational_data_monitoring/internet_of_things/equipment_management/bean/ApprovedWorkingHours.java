package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean;

import lombok.Data;

/**
 * 核定工时表
 * @author looli
 */
@Data
public class ApprovedWorkingHours {
    private String id;

    private String eqMacId;

    private String ratingType ;

    private String workDays ;

    private String amShift ;

    private String pmShift ;

    private String fmShift ;

    private String fullLoadTime ;
}