package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.litbo.hospital.operational_data_monitoring.software_interface.timedtask.Config;
import com.litbo.hospital.operational_data_monitoring.software_interface.timedtask.ConfigMapper;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.TimeVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.dao
 * @Author: looli
 * @CreateTime: 2019-08-01 10:37
 * @Description: 定时任务设置
 */
@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private ConfigMapper configMapper;

    @RequestMapping("/showTime")
    public Result showTime(){
        Config one = configMapper.findOne(1);
        return Result.success(one);
    }

}
