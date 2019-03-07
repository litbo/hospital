package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.service.EquipmentAccountService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 电子台账列表
     *
     * @param category            购置类别
     * @param state               状态
     * @param departmentId        部门id
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param equipmentNumber     设备编码
     * @param pageNum             当前页数
     * @param pageSize            每页显示的条数
     * @return PageInfo<MachineAccountVO>
     */
    @PostMapping("/selectEquipmentAccount")
    public Result selectEquipmentAccount(
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "state", required = false) String state,
            @RequestParam(name = "departmentId", required = false) String departmentId,
            @RequestParam(name = "equipmentPinyinCode", required = false) String equipmentPinyinCode,
            @RequestParam(name = "departmentCoding", required = false) String departmentCoding,
            @RequestParam(name = "equipmentNumber", required = false) String equipmentNumber,
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(equipmentAccountService.selectEquipmentAccount(category, state, departmentId, equipmentPinyinCode, departmentCoding, equipmentNumber, pageNum, pageSize));
    }

    /**
     * 科室设备综合查询
     *
     * @param state 状态
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding 院内编码
     * @param pageNum 当前页数
     * @param pageSize 每页显示的条数
     * @return PageInfo
     */
    @PostMapping("/selectKsEq")
    public Result selectKsEq(
            @RequestParam(name = "state", required = false) String state,
            @RequestParam(name = "equipmentPinyinCode", required = false) String equipmentPinyinCode,
            @RequestParam(name = "departmentCoding", required = false) String departmentCoding,
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

        return Result.success(equipmentAccountService.selectKsEq(state,equipmentPinyinCode,departmentCoding,pageNum,pageSize));
    }
}
