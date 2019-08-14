package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.bean;

import lombok.Data;

import java.util.Date;

/***
 * @author looli
 * 设备运行情况记录
 * 只存储当天记录
 */
@Data
public class Inspectdetail {

    private Integer ID;
    /**终端编号*/
    private String machineNumber;
    /**检查日期*/
    private String inspectDate;
    /**设备状态*/
    private String newStatus;
    /**创建时间*/
    private Date cerateTime;
    /**标记*/
    private String remark;
    /**开始时间*/
    private Date beginTime;
    /**结束时间*/
    private Date endTime;
    /**心跳包数量*/
    private Integer workNums;
}