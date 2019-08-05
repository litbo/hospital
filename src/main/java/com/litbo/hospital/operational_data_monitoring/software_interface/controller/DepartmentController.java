package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.litbo.hospital.operational_data_monitoring.software_interface.service.SBmService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DepartmentVO;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
                                 @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                 DepartmentVO departmentVO){
//        System.out.println(departmentVO);
        return Result.success(sBmService.showBm(pageNum, pageSize, departmentVO.getBmName()));
    }

    @RequestMapping("/showList")
    public Result showDepartment(){
        return Result.success(sBmService.showBmList());
    }


}
