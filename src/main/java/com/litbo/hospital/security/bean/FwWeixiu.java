package com.litbo.hospital.security.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class FwWeixiu {
    private String fwId;

    private Integer xxsbStatus;

    private String gzpc;

    private Integer gzyyId;

    private Integer gzmxId;

    private Integer gzbwId;

    private Integer gzwxFs;

    private Integer wxgznr;

    private String wxrId;

    private Double wxsyTime;

    private BigDecimal wxPrice;

    private String fzwxId;

    private String wxjg;

    private String gcsjy;

    private Integer zjStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gztjTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fwksTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pcwcTime;

}