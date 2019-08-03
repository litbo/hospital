package com.litbo.hospital.operational_data_monitoring.software_interface.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author looli
 * pacs收费列表
 */
@Data
public class PacsSflb {
    private String cSFID;

    private String cPatID;

    private String cBrXm;

    private String cBrNl;

    private String cBrXb;

    private String cBrBz;

    private String cMacID;

    private String cMacName;

    private Date cStime;

    private String cParts;

    private String cResult;

    private String cImgNo;

    private String cXmBm;

    private String cXmMc;

    private Date cYyDjsj;

    private String cYUserNO;

    private Date cJhsj;

    private String cCUserNo;

    private String cCDeptNo;

    private Date cCTime;

    private String cZUserNo;

    private Date cZTime;

    private String cFUserNo;

    private Date cFTime;

    private Date cDTime;

    private String cChkNo;

    private String cPacsJe;
    
}