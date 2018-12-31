package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.vo.MachineAccountSearchCriteriaVO;
import com.litbo.hospital.lifemanage.service.EquipmentAccountService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 电子台账Controller
 *
 * @author Administrator on 2018-12-16
 */
@RestController
@RequestMapping("/lifeManage")
public class EquipmentAccountController {
    @Autowired
    private EquipmentAccountService equipmentAccountService;

    @PostMapping("/selectEquipmentAccount")
    public Result selectEquipmentAccount(MachineAccountSearchCriteriaVO machineAccountSearchCriteriaVO){
        return Result.success(equipmentAccountService.selectEquipmentAccount(machineAccountSearchCriteriaVO));
    }
}
