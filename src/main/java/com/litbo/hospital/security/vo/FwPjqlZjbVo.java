package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class FwPjqlZjbVo {
    private Integer id;
    private Integer pjqlId;
    private String pjName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date qrTime;
    private String qrrName;
    private String qlrName;
    private Integer pjsgCount;

}
