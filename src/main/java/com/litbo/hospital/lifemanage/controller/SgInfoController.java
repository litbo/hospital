package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgInfo;
import com.litbo.hospital.lifemanage.service.SgInfoService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 申购单表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgInfoController {
    @Autowired
    SgInfoService sgInfoService;

    /**
     * 通过申购单主键查询申购单信息
     *
     * @param sgInfoId 申购单主键
     * @return Result
     */
    @GetMapping("/selectSgInfoById")
    public Result selectSgInfoById(@RequestParam(name = "sgInfoId") String sgInfoId) {
        return Result.success(sgInfoService.selectSgInfoById(sgInfoId));
    }

    /**
     * 添加申购单信息、参考设备信息、功能配置信息
     *
     * @param sgInfo    申购单信息
     * @return Result
     */
    @PostMapping("insertSgInfo")
    public Result insertSgInfo(@RequestBody SgInfo sgInfo) {
        sgInfoService.insertSgInfo(sgInfo);
        return Result.success();
    }

}
