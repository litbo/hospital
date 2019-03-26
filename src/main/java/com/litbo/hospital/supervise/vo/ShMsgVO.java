package com.litbo.hospital.supervise.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ShMsgVO {
    private Integer ztId;
    private Integer ztCzzt;   // 0待审核 1 不通过 2 通过
    private Integer syDays; // 试用天数
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ztDate;
    private String ztShyj;

    private Integer zdId;   //和nextShrId插入新的审核状态
    private String nextShrId;


}
