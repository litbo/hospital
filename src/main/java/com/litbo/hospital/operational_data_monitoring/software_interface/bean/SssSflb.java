package com.litbo.hospital.operational_data_monitoring.software_interface.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/***
 * 手术室收费明细
 */
@Data
public class SssSflb {
    private String sssSFID;
    private String sssPatID;
    private Date sssSfsj;
    private String sssBrXm;
    private String sssBrNl;
    private String sssBrXb;
    private String sssBrBz;
    private String sssYXmBm;
    private String sssXmJe;
    private Integer sssXmSl;
    private String sssMDeptId;
    private Date sssMTime;
    private String sssStatus;
    private String sssChkNo;
    private String sssJcbz;
    private String sssNDeptID;

}