package com.litbo.hospital.supervise.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PbJhVO {
    private String pbJhid;
    private String bmId;
    private String userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pbDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pbJsDate;


}
