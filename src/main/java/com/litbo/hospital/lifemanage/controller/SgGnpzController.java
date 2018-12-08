package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgGnpz;
import com.litbo.hospital.lifemanage.service.SgGnpzService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能配置表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgGnpzController {
    @Autowired
    private SgGnpzService sgGnpzService;

    /**
     * 添加功能配置
     *
     * @param sgGnpz 功能配置信息
     * @return Result
     */
    @PostMapping("insertSgGnpz")
    public Result insertSgGnpz(@RequestBody SgGnpz sgGnpz) {
        sgGnpzService.insertSgGnpz(sgGnpz);
        return Result.success();
    }

    /**
     * 通过参考厂商设备id查询对应的功能配置
     *
     * @param sgCkcssbId 参考厂商设备id
     * @return List<SgGnpz>
     */
    @GetMapping("selectSgGnpzBySgCkcssbId")
    public Result selectSgGnpzBySgCkcssbId(@RequestParam(name = "sgCkcssbId")String sgCkcssbId){
        return Result.success(sgGnpzService.selectSgGnpzBySgCkcssbId(sgCkcssbId));
    }

}
