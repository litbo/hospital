package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgYs;
import com.litbo.hospital.lifemanage.service.SgYsService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商务/临床/技术验收表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgYsController {
    @Autowired
    private SgYsService sgYsService;

    /**
     * 需验收设备列表
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return Result
     */
    @PostMapping("sgYsList")
    public Result sgYsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(sgYsService.sgYsList(pageNum, pageSize));
    }

    /**
     * 添加验收信息
     *
     * @param sgYs 验收信息
     * @return Result
     */
    @PostMapping("insertSgYs")
    public Result insertSgYs(@RequestBody SgYs sgYs) {
        sgYsService.insertSgYs(sgYs);
        return Result.success();
    }

}
