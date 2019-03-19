package com.litbo.hospital.supervise.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class GwShProcessDetailVO {
    private int id;
    private String gwName;
    private String ztCzname;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ztDate;
    private String shr;
    private String isTg;
    private String yj;

}
