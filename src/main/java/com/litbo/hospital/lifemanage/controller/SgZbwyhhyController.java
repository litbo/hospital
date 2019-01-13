package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.service.SgZbwyhhyService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 装备委员会会议信息表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgZbwyhhyController {
    @Autowired
    private SgZbwyhhyService sgZbwyhhyService;

    /**
     * 装备委员会年度采购计划
     *
     * @param year     年份
     * @param bmId     部门id
     * @param bh       申购单编号
     * @param pageNum  当前页数
     * @param pageSize 每页显示的记录数
     * @return Result
     */
    @PostMapping("/selectSgZbwyhYearPurchase")
    public Result selectSgZbwyhYearPurchase(@RequestParam(name = "year", required = false) String year,
                                            @RequestParam(name = "bmId", required = false) String bmId,
                                            @RequestParam(required = false, name = "bh") String bh,
                                            @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                            @RequestParam(name = "pageSize", defaultValue = "1", required = false) Integer pageSize) {
        return Result.success(sgZbwyhhyService.selectSgZbwyhYearPurchase(year, bmId, bh, pageNum, pageSize));
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
    @PostMapping("/selectSgZbwyhYearBudget")
    public Result selectSgZbwyhYearBudget(@RequestParam(name = "year", required = false) String year,
                                          @RequestParam(name = "bmId", required = false) String bmId,
                                          @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                          @RequestParam(name = "pageSize", defaultValue = "1", required = false) Integer pageSize) {
        return Result.success(sgZbwyhhyService.selectSgZbwyhYearBudget(year, bmId, pageNum, pageSize));
    }
}
