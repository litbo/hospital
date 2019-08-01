package com.litbo.hospital.operational_data_monitoring.operation_record.bean;

import lombok.Data;

import java.util.Date;

/***
 * @author looli
 * 设备运行情况记录
 */
@Data
public class Inspectdetail {

    private Integer ID;
    /**仪联网编号*/
    private String machineNumber;

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