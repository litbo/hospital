package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zjc
 * @create 2019-04-08 23:43
 */
@Data
public class FwFkVo {

    private String fkrXm;

    private String fkFs;

    private String fkFphm;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date fkTime;

    private BigDecimal fkPrice;


}
