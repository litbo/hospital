package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.ReportMessage;
import com.litbo.hospital.lifemanage.service.EmergencyService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 应急管理Controller
 *
 * @author Administrator on 2018-12-17
 */
@RestController
@RequestMapping("/lifeManage")
public class EmergencyController {
    @Autowired
    private EmergencyService emergencyService;

    /**
     * 查询本科室所有设备
     *
     * @param userId 用户id
     * @return Result
     */
        @PostMapping("/selectEmergencyList")
    public Result selectEmergencyList(@RequestParam(name = "userId") String userId) {
        return Result.success(emergencyService.selectEmergencyList(userId));
    }

    @PostMapping("/insertEmergencyEquipment")
    public Result insertEmergencyEquipment(@RequestBody ReportMessage reportMessage){
        return Result.success();
    }

}
