package com.litbo.hospital.efficiency.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * description: 开机率
 * @Author: jz
 * @Date: 2019/8/1 9:47
 */

@Data
public class OpenVO {

    /** 设备的编号 */
    private String eqCode;

    /** 设备的名字 */
    private String eqName;

    /** 设备的开机天数 */
    private Integer realDays;

    /** 设备的应开机天数 */
    private Integer workDays;

    /** 设备的开机率 */
    private String rating;

    /** 设备开机率的排名 */
    private Integer ranking;

}
