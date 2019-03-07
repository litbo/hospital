package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ListFwPjzdVo {

    private Integer pjzdId;

    private String pjbh;

    private String pjName;

    private String pjGgxh;

    private String pjZczh;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pjZczDqTime;

    private String ghsName;

    private String scqyName;

    private Integer pjsgCount;
}
