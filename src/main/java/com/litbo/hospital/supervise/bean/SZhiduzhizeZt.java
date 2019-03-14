package com.litbo.hospital.supervise.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SZhiduzhizeZt {
    private Integer ztId;

    private Integer zdId;

    private String userId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ztDate;

    private String ztCzname;

    private Integer ztCzzt;

    private String ztShyj;

}