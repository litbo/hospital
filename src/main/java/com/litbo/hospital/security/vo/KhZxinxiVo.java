package com.litbo.hospital.security.vo;

import lombok.Data;

@Data
public class KhZxinxiVo {
    private String id;//主键

    private String pxry;

    private String ksry;

    private String khry;

    private String pjyj;

    private String bmName;

    private String userName;//多个

    private String pxjg;

    private String llcj;//多个

    private String sjcz;//多个

    private String khjg;//多个

    private String jhId;//关联计划表
}
