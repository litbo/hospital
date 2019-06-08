package com.litbo.hospital.security.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SelectFwPjzdVo {
    private Integer id;

    private String pjfl;

    private Integer pjKw;

    private Integer sbcsId;

    private Integer sbcsId1;

    private Integer eqId;

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

    private BigDecimal zbPrice;

}