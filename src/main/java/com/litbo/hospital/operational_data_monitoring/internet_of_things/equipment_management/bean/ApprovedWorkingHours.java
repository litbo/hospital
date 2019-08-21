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

    /**额定值类型*/
    private String ratingType ="1";
    /**工作天数*/
    private String workDays ="27";
    /**上午班*/
    private String amShift ="4";
    /**下午班*/
    private String pmShift ="4";
    /**晚班*/
    private String fmShift ="0";
    /**满负荷工时*/
    private String fullLoadTime ="8";
}