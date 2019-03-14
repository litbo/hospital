package com.litbo.hospital.supervise.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class ZhuduAndZdZzVO {
    private Integer zdId;

    private String bmId;

    private String zdName;

    private String userId;

    private String docUrl;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    private String zdContent;

    private Integer zdZt;

    private Integer syTianshu;

    private Integer sySyts;

    private Integer zdXgcs;

    private String ztCzname;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ztDate;
}
