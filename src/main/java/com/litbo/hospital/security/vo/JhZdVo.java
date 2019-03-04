package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zjc
 * @create 2019-02-22 16:00
 */
@Data
public class JhZdVo {

    private Integer id;

    private String pxAddr;

    private String jhName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jhKstime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jhJstime;

    private String jhPxlx;

    private String jhPxxz;

    private String userId;

    private String userXm;
}
