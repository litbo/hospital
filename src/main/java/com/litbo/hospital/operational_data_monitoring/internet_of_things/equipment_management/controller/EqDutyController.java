package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqDutyTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqDutyTabService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller
 * @Author: looli
 * @CreateTime: 2019-07-31 13:58
 * @Description: todo
 */
@RestController
@RequestMapping("/duty")
public class EqDutyController {

    @Autowired
    private EqDutyTabService eqDutyTabService;

    @RequestMapping("/show")
    public Result show(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                       @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        PageInfo pageInfo = eqDutyTabService.selectAll(pageNum, pageSize);
        return Result.success(pageInfo);
    }

}
