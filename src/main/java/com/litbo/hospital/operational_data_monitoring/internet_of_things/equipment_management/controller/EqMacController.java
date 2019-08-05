package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqDutyTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqMacTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.DeviceparameterService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqDutyTabService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqMacTabService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller
 * @Author: looli
 * @CreateTime: 2019-07-31 11:12
 * @Description: todo
 */
@RestController
@RequestMapping("/eqmac")
public class EqMacController {
    @Autowired
    private EqMacTabService eqMacTabService;
    @Autowired
    private DeviceparameterService deviceparameterService;
    @Autowired
    private EqDutyTabService eqDutyTabService;

    @RequestMapping("/save")
    public Result save(DeviceparameterVO deviceparameterVO){
        EqMacTab eqMacTab = new EqMacTab();
        BeanUtils.copyProperties(deviceparameterVO,eqMacTab);
        eqMacTab.setId(IDFormat.getIdByIDAndTime("eq_mac_tab","id"));
        eqMacTab.setMacid(IDFormat.getIdByIDAndTime("eq_mac_tab","MacID"));
        eqMacTabService.save(eqMacTab);
        deviceparameterService.save(deviceparameterVO);
        EqDutyTab eqDutyTab = new EqDutyTab();
        eqDutyTab.setEqMacId(eqMacTab.getMacid());
        eqDutyTab.setId(IDFormat.getIdByIDAndTime("eq_duty_tab","id"));
        eqDutyTabService.save(eqDutyTab);
        return Result.success();
    }

//    /**
//     * 显示设备参数表和设备表信息
//     */
//    @RequestMapping("/show")
//    public Result show(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
//                       @RequestParam(required = false,defaultValue = "1") Integer pageNum){
//        PageInfo pageInfo = deviceparameterService.showEqNetWork(pageNum, pageSize);
//        return Result.success(pageInfo);
//    }
}
