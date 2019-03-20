package com.litbo.hospital.supervise.vo;

import lombok.Data;

@Data
public class BmsTreeVO {
    private String obmId;
    private String bmId;
    private String bmName;
    private String userId;
    private String bmTel;
    private String bmAddr;
    private String wxFlag;
    private String pBmId;
    private String xbmFlag;

    private Integer isGlbm;
    private Integer gkCode;
    private String fzrName;
}
