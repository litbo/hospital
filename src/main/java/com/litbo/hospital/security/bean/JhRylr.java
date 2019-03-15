package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class JhRylr {
    private Integer id;

    private String jhlrPxgw;

    private Integer jhId;

    private Double jhlrCj;

    private String jhlrSgzmc;

    private String jhlrZjurl;

    private Integer sbId;

    private String jhlrFzdw;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jhlrFzTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jhlrYxq;

    private String empId;

}