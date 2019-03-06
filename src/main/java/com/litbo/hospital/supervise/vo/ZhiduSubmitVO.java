package com.litbo.hospital.supervise.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ZhiduSubmitVO {
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

    private String shrId;   //审核人id



}
