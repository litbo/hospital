package com.litbo.hospital.user.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class SysGgxz {
    private Integer id;

    private String wjmc;
    @JsonFormat(pattern ="yyyy-MM-dd" )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scrq;

    private String scr;

    private String url;

    private Integer status;

    private String wjsm;


}