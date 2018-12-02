package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

/**
 * 院办公会会议信息表实体类
 */
@Data
public class SgYbghhy {
    private String ybghhyId;

    private String ybghhySjy;

    private Date ybghhySj;

    private String ybghhyDd;

    private String extendOne;

    private String extendTwo;

    private String ybghhyChry;

    private String ybghhyNr;
}