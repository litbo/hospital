package com.litbo.hospital.security.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwFk {
    private Integer id;

    private String fkFs;

    private Date fkTime;

    private String fkFphm;

    private String userId;

    private BigDecimal fkPrice;

    private Integer fkCs;

    private String fkHtbh;

}