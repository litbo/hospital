package com.litbo.hospital.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwFk {
    private Integer id;

    private String fkFs;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fkTime;

    private String fkFphm;

    private String userId;

    private BigDecimal fkPrice;

    private Integer fkCs;

    private String fkHtbh;

    private String fkrXm;

}