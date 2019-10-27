package com.litbo.hospital.security.vo;

import lombok.Data;

@Data
public class KhVos {

    private String id;//主键

    private KhTablesVo []listZb;

    private String pxry;

    private String ksry;

    private String khry;

    private String pjyj;

    private String jhId;//关联计划表
}
