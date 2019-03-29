package com.litbo.hospital.supervise.vo;

import lombok.Data;

import java.util.Date;

@Data
public class GwZpjMsgVO {
    private String gwId;
    private String gwName;
    private String gwZz;
    private String docUrl;


    private String sqUserId;
    private String sqUserName;
    private String zpjReason;
    private Date sqDate;
}
