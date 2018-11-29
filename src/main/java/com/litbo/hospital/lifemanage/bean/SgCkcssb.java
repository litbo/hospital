package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 参考厂商设备表
 */
@Data
public class SgCkcssb {
    private String ckcssbId;

    private String sgId;

    private Integer sbcsId;

    private String ckcssbXh;

    private String ckcssbGg;

    private Integer ckcssbSl;

    private BigDecimal ckcssbGj;

    private String extendOne;

    private String extendTwo;
}