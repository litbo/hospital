package com.litbo.hospital.security.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class FwPjzd {
    private Integer id;

    private String pjfl;

    private Integer pjKw;

    private Integer pjScqyId;

    private Integer pjGhsId;

    private Integer sbId;

    private String pjName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zbTime;

    private String pjGgxh;

    private String pjBzdw;

    private String pjZczh;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pjZczDqTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pjXgTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pjCjTime;

    private String pjSzm;

    private String pjbh;

}