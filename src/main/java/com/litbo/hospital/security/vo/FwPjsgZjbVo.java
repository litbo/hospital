package com.litbo.hospital.security.vo;

import lombok.Data;

import java.util.Date;
@Data
public class FwPjsgZjbVo {
    private Integer id;
    private Integer pjsgId;
    private String pjName;
    private Date pjRkTime;
    private String sgrName;
    private String shrName;
    private Integer pjsgCount;
    private Double pjsgPrice;

}
