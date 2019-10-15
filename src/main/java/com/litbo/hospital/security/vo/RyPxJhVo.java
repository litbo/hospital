package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RyPxJhVo {

    private Integer id;

    private String jhName;

    private String zbdw;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String jhKstime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String jhJstime;

    private String jhPxbh;

    private String jhPxlx;

    private String jhPxxz;

    private String jhPxnrlb;

    private String userId;

    private String pxAddr;

    private String pxNr;

}
