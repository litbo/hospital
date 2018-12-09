package com.litbo.hospital.security.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ListFwPjzdVo {

    private String pjbh;

    private String pjName;

    private String pjGgxh;

    private String pjZczh;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pjZczDqTime;

    private String ghsName;

    private String scqyName;
}
