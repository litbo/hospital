package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class JhZd {
    private Integer id;

    private String jhName;

    private String zbdw;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jhKstime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jhJstime;

    private String jhPxlx;

    private String jhPxxz;

    private String jhPxnrlb;

    private String jhSblx;

    private String userId;

    private String pxZjr;

    private String pxAddr;

    private String pxNr;

}