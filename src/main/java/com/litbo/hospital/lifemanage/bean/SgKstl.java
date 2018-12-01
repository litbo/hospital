package com.litbo.hospital.lifemanage.bean;

import lombok.Data;

import java.util.Date;

/**
 *科室讨论表实体类
 */
@Data
public class SgKstl {
    private String kstlId;

    private String userIdJl;

    private String bmId;

    private Date kstlTime;

    private String kstlAddr;

    private String extendOne;

    private String extendTwo;

    private String kstlYj;

    private String kstlContent;
}