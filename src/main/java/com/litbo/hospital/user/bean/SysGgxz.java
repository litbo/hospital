package com.litbo.hospital.user.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class SysGgxz {
    private Integer id;

    private String wjmc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scrq;

    private String scr;

    private String url;

    private Integer status;

    private String wjsm;


}