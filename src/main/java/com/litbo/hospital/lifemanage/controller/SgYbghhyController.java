package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.service.SgYbghhyService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 院办公会会议信息表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgYbghhyController {
    @Autowired
    private SgYbghhyService sgYbghhyService;

    /**
     * 院办公会年度采购计划
     *
     * @param year     年份
     * @param bmId     部门id
     * @param bh       申购单编号
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return Result
     */
    @PostMapping("/selectSgYbghhyYearPurchase")
    public Result selectSgYbghhyYearPurchase(@RequestParam(name = "year", required = false) String year,
                                             @RequestParam(name = "bmId", required = false) String bmId,
                                             @RequestParam(required = false, name = "bh") String bh,
                                             @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                             @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return Result.success(sgYbghhyService.selectSgYbghhyYearPurchase(year, bmId, bh, pageNum, pageSize));
    }

    /**
     * 院办公会年度采购预算
     *
     * @param yearBudget 年份
     * @param bmIdBudget 部门id
     * @param pageNum    当前页数
     * @param pageSize   每页显示的记录数
     * @return Result
     */
    @PostMapping("/selectSgYbghhyYearBudget")
    public Result selectSgYbghhyYearBudget(@RequestParam(name = "yearBudget", required = false) String yearBudget,
                                           @RequestParam(name = "bmIdBudget", required = false) String bmIdBudget,
                                           @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                           @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return Result.success(sgYbghhyService.selectSgYbghhyYearBudget(yearBudget, bmIdBudget, pageNum, pageSize));
    }

    /**
     * 院办公会会议详情
     *
     * @param ybghhyId 院办公会会议id
     * @return Result
     */
    @PostMapping("/selectSgYbghhyById")
    public Result selectSgYbghhyById(@RequestParam(name = "ybghhyId") String ybghhyId) {
        return Result.success(sgYbghhyService.selectSgYbghhyById(ybghhyId));
    }
}
