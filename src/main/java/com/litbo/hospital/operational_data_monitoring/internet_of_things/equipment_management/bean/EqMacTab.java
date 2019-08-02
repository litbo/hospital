package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean;

import lombok.Data;

/**
 * 设备联网表
 * @author looli
 */
@Data
public class EqMacTab {
    private String id;

    private String deptid;

    private String equid;

    private String macid;

    private String macip;

    private String flag;

    private String haspacs;

    private String hasworkbox;

    private String macrule;

    private String pmacid;
}