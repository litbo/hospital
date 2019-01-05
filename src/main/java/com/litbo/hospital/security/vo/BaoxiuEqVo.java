package com.litbo.hospital.security.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zjc
 * @create 2019-01-05 18:08
 */
@Data
public class BaoxiuEqVo {

    private String eqId;

    private String eqName;

    private String bmName;

    //设备编号
    private String eqSbbh;
    //资产编号
    private String eqZcbh;
    //设备规格
    private String eqGg;
    //设备型号
    private String eqXh;

    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date eqQysj;

}
