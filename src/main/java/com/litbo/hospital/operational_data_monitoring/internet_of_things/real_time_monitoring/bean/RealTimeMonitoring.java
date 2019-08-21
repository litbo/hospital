package com.litbo.hospital.operational_data_monitoring.internet_of_things.real_time_monitoring.bean;

import lombok.Data;

/**
 * 设备实时监控返回数据
 */
@Data
public class RealTimeMonitoring {
    private String bmName;
    private String eqSbbh;
    private String eqName;
    private String eqXh;
    private String status;
    private String syzt;
}
