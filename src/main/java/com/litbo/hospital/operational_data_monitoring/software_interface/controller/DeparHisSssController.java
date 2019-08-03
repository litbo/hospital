package com.litbo.hospital.operational_data_monitoring.software_interface.controller;

import com.litbo.hospital.operational_data_monitoring.software_interface.bean.DeparHisSss;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.DeparHisSssService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.BmDe;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.controller
 * @Author: looli
 * @CreateTime: 2019-07-31 12:37
 * @Description: todo
 */
@RestController
@RequestMapping("/depar")
public class DeparHisSssController {
    @Autowired
    private DeparHisSssService sssService;

    /**
     *
     * @param deparHisSss
     * @return
     */
    @RequestMapping("/save")
    public Result save(DeparHisSss deparHisSss){
        sssService.delete(deparHisSss.getHisDeptid());
        sssService.save(deparHisSss);
        return Result.success();
    }



}
