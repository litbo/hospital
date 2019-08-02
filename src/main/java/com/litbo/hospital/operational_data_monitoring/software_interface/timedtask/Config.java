package com.litbo.hospital.operational_data_monitoring.software_interface.timedtask;

import lombok.Data;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.timedtask
 * @Author: looli
 * @CreateTime: 2019-07-29 09:00
 * @Description: todo
 */
@Data
public class Config {
    /**id*/
    private Integer id;
    /**执行的表达式*/
    private String cron;
    /**周期*/
    private String cycle;
    /**执行的时间*/
    private String time;
}
