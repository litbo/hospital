package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.SBmService;
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
 * @CreateTime: 2019-07-28 10:21
 * @Description: 获取部门信息
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private SBmService sBmService;

    @RequestMapping("/show")
    public Result showDepartment(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        PageInfo pageInfo = sBmService.showBm(pageNum, pageSize, null);
        return Result.success(pageInfo);
    }
}
