package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgKxxfx;
import com.litbo.hospital.lifemanage.service.SgKxxfxService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 可行性分析表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgKxxfxController {
    @Autowired
    private SgKxxfxService sgKxxfxService;

    /**
     * 添加或更新可行性分析表信息
     *
     * @param sgKxxfx 可行性分析信息
     * @return Result
     */
    @PostMapping("insertSgKxxfx")
    public Result insertSgKxxfx(@RequestBody SgKxxfx sgKxxfx) {
        sgKxxfxService.insertOrUpdateSgKxxfx(sgKxxfx);
        return Result.success();
    }

    /**
     * 根据申购单主键查询可行性分析信息
     * @param sgInfoId 申购单主键
     * @return Result 可行性分析信息
     */
    @PostMapping("selectSgKxxfxBySgInfoId")
    public Result selectSgKxxfxBySgInfoId(@RequestParam("sgInfoId") String sgInfoId) {
        SgKxxfx sgKxxfx = sgKxxfxService.selectSgKxxfxBySgInfoId(sgInfoId);
        if (sgKxxfx != null){
            return Result.success(sgKxxfx);
        }else{
            return Result.success();
        }
    }
}
