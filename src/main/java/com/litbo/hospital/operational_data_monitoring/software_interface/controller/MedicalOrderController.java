package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.HisSfxmDict;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.EqYzTabService;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.HisSfxmDictService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.controller
 * @Author: looli
 * @CreateTime: 2019-07-28 10:55
 * @Description: todo
 */
@RestController
@RequestMapping("/medical")
public class MedicalOrderController {
    @Autowired
    private HisSfxmDictService service;

    @RequestMapping("/show")
    public Result show(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                       @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                       @RequestParam(required = false) String name){
        if (name == null || name.equals("")){
            PageInfo pageInfo = service.showXm(pageNum, pageSize);
            return Result.success(pageInfo);
        }else {
            PageInfo pageInfo = service.showXmByName(name, pageNum, pageSize);
            return Result.success(pageInfo);
        }
    }
}
