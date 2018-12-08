package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgGnpz;
import com.litbo.hospital.lifemanage.service.SgGnpzService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("insertSgGnpz")
    public Result insertSgGnpz(@RequestBody SgGnpz sgGnpz) {
        sgGnpzService.insertSgGnpz(sgGnpz);
        return Result.success();
    }

}
