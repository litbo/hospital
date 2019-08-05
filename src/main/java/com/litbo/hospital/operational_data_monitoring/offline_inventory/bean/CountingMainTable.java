package com.litbo.hospital.operational_data_monitoring.offline_inventory.bean;

import lombok.Data;

import java.util.Date;

@Data
public class CountingMainTable {
    private String id;

    private String cPddh;

    private String cLrsj;

    private String cLrr;

    private String cFlag;

    private String cShr;

    private String cShsj;

    private String cBz;

    private Date datecreated;

    private Date datemodified;

    private String cPdks;

    private String cYwlx;

    private String cSbgx;

    private String cSbgxr;

    private Date cSbgxrq;

    private String cXml;
}