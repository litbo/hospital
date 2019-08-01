package com.litbo.hospital.operational_data_monitoring.software_interface.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author looli
 * his收费明细表
 */
@Data
public class HisSflb {
    /**收费记录*/
    private String hisSFID;

    private String hisAssetNO;
    /**病人id*/
    private String hisPatID;
    /**记账时间*/
    private Date hisSfsj;

    private String hisBrXm;

    private String hisBrNl;

    private String hisBrXb;

    private String hisBrBz;

    private String hisYXmBm;

    private String hisXmBm;

    private BigDecimal hisXmJe;

    private Integer hisXmSl;

    private String hisMDeptID;

    private Date hisMTime;
    /**状态*/
    private String hisstatus;
}