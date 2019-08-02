package com.litbo.hospital.operational_data_monitoring.operation_record.vo;

import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqMacTab;
import com.litbo.hospital.operational_data_monitoring.operation_record.bean.Inspectdetail;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.user.bean.EqInfo;
import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.operation_record.vo
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
    private Date beginTime;
    /**结束时间*/
    private Date endTime;
    /**心跳包数量*/
    private Integer workNums;
    /**待机时长*/
    private String standbyTime;
    /**工作时长*/
    private String workHours;
    /**设备数量*/
    private Integer eqNumber;
    //设备联网信息
    //联网仪编号
    private String macid;

    //部门信息
    //部门名称
    private String bmName;

    //设备信息
    //设备编号
    private String eqSbbh;
    //资产编号
    private String eqZcbh;
    //设备名称
    private String eqName;
    //设备型号
    private String eqXh;
}
