package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.service.SgYbghhyService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 院办公会会议信息表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgYbghhyController {
    @Autowired
    private SgYbghhyService sgYbghhyService;

    /**
     * 装备委员会年度采购计划
     *
     * @param year     年份
     * @param bmId     部门id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return Result
     */
    @PostMapping("/selectSgYbghhyYearPurchase")
    public Result selectSgYbghhyYearPurchase(@RequestParam(name = "year") String year,
                                             @RequestParam(name = "bmId", required = false) String bmId,
                                             @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                             @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return Result.success(sgYbghhyService.selectSgYbghhyYearPurchase(year, bmId, pageNum, pageSize));
    }

    /**
     * 装备委员会年度采购预算
     *
     * @param year     年份
     * @param bmId     部门id
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return Result
     */
    @PostMapping("/selectSgYbghhyYearBudget")
    public Result selectSgYbghhyYearBudget(@RequestParam(name = "year") String year,
                                           @RequestParam(name = "bmId", required = false) String bmId,
                                           @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                           @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return Result.success(sgYbghhyService.selectSgYbghhyYearBudget(year, bmId, pageNum, pageSize));
    }
}
