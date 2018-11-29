package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

/**
 * 大型医学装备考察报告表
 */
@Data
public class SgDxyxzbkc {
    private String dxzbId;

    private Date dxzbSj;

    private String extendOne;

    private String extendTwo;

    private String dxzbDdnr;

    private String dxzbYj;
}