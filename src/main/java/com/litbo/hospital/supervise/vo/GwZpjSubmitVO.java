package com.litbo.hospital.supervise.vo;

import lombok.Data;

import java.util.Date;

@Data
public class GwZpjSubmitVO {
    private String gwId;
    private Integer ztCzzt;   // 0待审核 1 不通过 2 通过
    private String ztShyj;
    private Date ztDate;
}
