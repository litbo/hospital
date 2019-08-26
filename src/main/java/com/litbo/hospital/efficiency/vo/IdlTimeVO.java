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
