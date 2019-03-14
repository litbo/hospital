package com.litbo.hospital.supervise.vo;

import lombok.Data;

import java.util.Date;
@Data
public class GWSubmitVO {
//    private SGangwei sGangwei;
    private Integer gwId;       //制度信息对象
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

    private String shrId;   //审核人id


}
