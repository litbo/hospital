package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo;

import lombok.Data;

import java.util.Date;

@Data
public class WorkTimeVO {
    /*日期*/
    private String datetime;
    /*工作时间*/
    private long workTime;
    /*待机时间*/
    private long waitTime;
    /*关机时间*/
    private long closeTime;
    /*故障时间*/
    private long brokenTime;
}
