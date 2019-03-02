package com.litbo.hospital.beneficial.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
* 新增设备财务vo
* */
@Data
public class InsertSbcwVo {

    private String bmName;

    private Integer bmId;

    private String eqName;

    private Integer eqId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date kmSj;

    private List<UpdateKmVo> kmNameAndValue;

    private String kmName;

    private Integer qjlc;

    private BigDecimal kmValue;
}
