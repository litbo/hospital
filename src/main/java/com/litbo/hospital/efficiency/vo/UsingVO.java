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
