package com.litbo.hospital.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
*   用于展示的数据
* @version :
* @author : ljl
**/
@Data
public class EqShowVo {

    private Integer eqId;

    private String eqSbbh;

    private String eqPym;

    private String eqName;

    private String eqZcbh;

    private String eqPmName;

    private String eqGg;

    private String eqXh;

    private String bmName;

    private String eqPp;

    private String eqPrice;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date eqQysj;

    private String eqSyzt;
}
