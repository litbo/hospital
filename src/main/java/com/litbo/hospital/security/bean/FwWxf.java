package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class FwWxf {
    private Integer id;

    private String user1Id;

    private String fwId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date wxfSqtime;

    private Double wxfRgf;

    private Double wxfCjrgf;

    private String user2Id;

    private Integer wxfStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date wxfSptime;

    private String wxfSpyj;

}