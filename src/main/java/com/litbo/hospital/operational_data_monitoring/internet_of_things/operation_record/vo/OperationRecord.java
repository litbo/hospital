package com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.operation_record.vo
 * @Author: looli
 * @CreateTime: 2019-07-22 17:29
 * @Description: 运行记录显示对象
 */
@Data
public class OperationRecord {

    //运行记录
    /**设备状态*/
    private String newStatus;
    /**开始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date beginTime;
    /**结束时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date endTime;
    /**心跳包数量*/
    private Integer workNums;
    /**待机时长*/
    private String standbyTime;
    /**工作时长*/
    private String workHours;
    /**设备数量*/
    private String eqNumber;
    //设备联网信息
    //联网仪编号
    private String macid;
    //联网仪编号
    private String machineNumber;

    //科室信息
    //科室名称
    private String bmName;
    private String bmId;

    //设备信息
    //设备编号
    private String eqSbbh;
    //资产编号
    private String eqZcbh;
    //设备名称
    private String eqName;
    //设备型号
    private String eqXh;
    /*重量*/
    private String currWeight;

    private String pym;
    private String deviceCode;
    private String positionValue;

}
