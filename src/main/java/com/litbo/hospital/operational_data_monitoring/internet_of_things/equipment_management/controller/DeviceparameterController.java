package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.DeviceparameterService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller
 * @Author: looli
 * @CreateTime: 2019-07-30 17:27
 * @Description: todo
 */
@RestController
@RequestMapping("/deviceparameter")
public class DeviceparameterController {

    @Autowired
    private DeviceparameterService service;

    /**
     * 显示设备联网信息
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping("/show")
    public Result showEqNetWork(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                SearchVO searchVO){
        System.out.println(searchVO);
        PageInfo pageInfo = service.showEqNetWork(pageNum, pageSize,searchVO);
        return Result.success(pageInfo);
    }

    /**
     * 根据ip显示设备信息
     * @param ip
     * @return
     */
    @RequestMapping("/showOne")
    public Result showOne(String ip){
        DeviceparameterVO deviceparameterVO = service.showOne(ip);
        return Result.success(deviceparameterVO);
    }
}
