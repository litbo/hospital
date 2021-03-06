package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 设备参数表设备编号等于资产编号
 */
@Data
public class Deviceparameter {
    private int eqId;
    private String deviceCode;

    private String inspectType;

    private String keepTime;

    private String startElectic;

    private String endElectic;

    private String inDistance;

    private String outDistance;

    private String imageStart;

    private String imageEnd;

    private String weightStart;

    private String weightEnd;

    private String pECounting;

    private String spare;

    private String heartTime;

    private String repeatInterval;

    private String endPointIP;

    private String endPointPort;

    private String repairRemind;

    private String maintainRemind;

    private String sumWorkTime;

    private String sumWaitTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date clearTime;

    private String sumCloseTime;

    private String sumRepairTime;

    private String sumMaintainTime;

    private String unRepairOpenTime;

    private String stopTime;

    private Boolean ifHaveDetail;

    private String maxElectic;

    private String waiteElectic;

    private String remark1;



    private String remark2;

    private String remark3;

    private String remark4;

    private String waitPower;

    private String workPower;

    private String voltage;

    private String reportPrice;

    private String couplingAgentPrice;

    private String filmPrice;

    private String reagentPersonPrice;

    private String reagentItemPrice;

    private String userType;

    private String maxCurrent;

    private String minCurrent;

    private String repairFees;

    private String maintainFees;

    private String qulityNum;

    private String errorRate;
    private String machineNumber;
    private String maintainStatus;
    private String softVerChange;
    private String hardCloseFlag;
    private String maxWdCurrent;
    private String minWdCurrent;
    private String maxSdCurrent;
    private String minSdCurrent;
    private String maxYwCurrent;
    private String minYwCurrent;

}