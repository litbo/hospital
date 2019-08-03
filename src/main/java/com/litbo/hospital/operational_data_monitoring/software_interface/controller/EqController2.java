package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.EqPacs;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.EqInfoService2;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.PacsService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.EqPacsVO;
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
 * @CreateTime: 2019-07-28 10:29
 * @Description: todo
 */
@RestController
@RequestMapping("/eq")
public class EqController2 {
    @Autowired
    private EqInfoService2 service;
    @Autowired
    private PacsService pacsService;

    @RequestMapping("/show")
    public Result showEq(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                         @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                         @RequestParam(required = false) String name){
        if (name == null || name.equals("")){
            PageInfo pageInfo = service.showEqInfo(pageNum, pageSize, null);
            return Result.success(pageInfo);
        }else {
            PageInfo pageInfo = service.showEqInfo(pageNum, pageSize, name);
            return Result.success(pageInfo);
        }
    }

    /**
     * 保存设备与pacs关联信息
     * @param eqPacs
     * @return
     */
    @RequestMapping("/save")
    public Result save(EqPacs eqPacs){
        pacsService.save(eqPacs);
        return Result.success();
    }
}
