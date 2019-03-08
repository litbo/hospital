package com.litbo.hospital.user.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

/**
*
* 作息时间
* @author : ljl
**/
@Data
public class SysZxsj {
    private Integer id;
    @DateTimeFormat(pattern ="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date amSbsj;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date amXbsj;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date pmSbsj;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date pmXbsj;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date ybSbsj;
    @DateTimeFormat(pattern = "HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date ybXbsj;


}