package com.litbo.hospital.security.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class FwShouli {
    private String id;

    private Integer xyStatus;

    private Integer gztjStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date slTime;

    private String wxfs;

    private String slrId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ydwxTime;

    private String slBz;

}