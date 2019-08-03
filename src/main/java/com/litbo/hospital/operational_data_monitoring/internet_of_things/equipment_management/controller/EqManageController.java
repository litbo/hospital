package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqInfoService;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.controller
 * @Author: looli
 * @CreateTime: 2019-08-02 11:17
 * @Description: todo
 */
@RestController
@RequestMapping("/eqmanage")
public class EqManageController {

    @Autowired
    private EqInfoService eqInfoService;

    /**
     * 显示设备信息
     * @return
     */
    @RequestMapping("/show")
    public Result show(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                       @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                       SearchVO searchVO){
        System.out.println(searchVO);
        PageInfo pageInfo = eqInfoService.selectAllBy(pageNum, pageSize, searchVO);
        return Result.success(pageInfo);
    }

}
