package com.litbo.hospital.efficiency.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * description:
 * @Author: jz
 * @Date: 2019/8/2 12:29
 */
@Data
public class IdlTimeVO {

    /** 搜索的开始时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date startSTime;

    /** 搜索的结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endSTime;

    /** 搜索设备名字 */
    private String eqSName;

    /** 搜索部门名字 */
    private String bmSName;

    /** 设备编号 */
    private String eqCode;

    /** 设备名字 */
    private String eqName;

    /** 闲置时间 */
    private String idleTimes;

    /** 值班时长 */
    private String workDays;

    /** 平均闲置时间 */
    private String avgTimes;

    /** 排名 */
    private Integer ranking;

}
