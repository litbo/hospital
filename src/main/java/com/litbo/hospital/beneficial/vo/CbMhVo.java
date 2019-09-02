package com.litbo.hospital.beneficial.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.litbo.hospital.lifemanage.MyUtils.String2DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/*
* 模糊查询VO
* */
@Data
public class CbMhVo {

    private String kssj;

    private String jssj;

    private String bmNameByx;

    private String eqNameByx;
}
