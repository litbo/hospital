package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zjc
 * @create 2019-02-21 13:39
 */
@Data
public class HtVo {

    private String id;

    private String htName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date htTime;

    private BigDecimal htPrice;

    private String sbcsName;
}
