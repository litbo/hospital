package com.litbo.hospital.supervise.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ZpjMsgVO {
    private String zdId;
    private String bmId;
    private String zdName;
    private String docUrl;
    private String zdContent;
    private String sqUserId;
    private String zpjReason;
    private Date sqDate;
}
