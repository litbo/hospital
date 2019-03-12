package com.litbo.hospital.supervise.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class GangWeiAndZtVO {
    private Integer gwId;
    private String gwName;
    private String gwLevel;


    private String gwZz;
    private String userId;
    private Date createTime;
    private String docUrl;
    private Integer gwZzZt;
    private Integer syTianshu;
    private Integer sySyts;
    private Integer zdXgcs;

    private String ztCzname;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ztDate;
}
