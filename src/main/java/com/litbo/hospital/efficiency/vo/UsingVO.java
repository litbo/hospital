package com.litbo.hospital.efficiency.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * description: 机时利用率
 * @Author: jz
 * @Date: 2019/8/1 16:28
 */
@Data
public class UsingVO {

    /** 搜索的开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date startSTime;

    /** 搜索的结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endSTime;

    /** 搜索部门的名字 */
    private String bmSName;

    /** 搜索的设备名字 */
    private String eqSName;

    /** 设备编号 */
    private String eqCode;

    /** 设备简称 */
    private String eqJc;

    /** 工作时长 */
    private Double realTimes;

    /** 核定时长 */
    private Double workTimes;

    /** 机时利用率 */
    private String rating;

    /** 排名 */
    private Integer ranking;


}
