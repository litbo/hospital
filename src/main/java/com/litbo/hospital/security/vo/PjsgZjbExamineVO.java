package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class PjsgZjbExamineVO {
    private String pjName;
    private String pjGgxh;
    private String pjZczh;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date pjZczDqTime;
    private String scqyName;
    private String ghsName;
    private Integer pjsgCount;
    private BigDecimal pjsgPrice;
}
