package com.litbo.hospital.user.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
*
* 作息时间
* @author : ljl
**/
@Data
public class SysZxsj {
    private Integer id;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date amSbsj;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date amXbsj;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date pmSbsj;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date pmXbsj;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date ybSbsj;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date ybXbsj;


}