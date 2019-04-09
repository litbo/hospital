package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zjc
 * @create 2019-04-09 0:02
 */
@Data
public class FwHtXqVo {

    private String fkHtbh;

    private String htName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date htTime;

    private BigDecimal htPrice;

    private List<FwFkVo> fwFkVo;
}
