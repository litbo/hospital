package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgPlan;
import com.litbo.hospital.lifemanage.service.SgPlanService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

/**
 * 审核计划Controller
 *
 * @author Administrator on 2018-12-29
 */
@RestController
@RequestMapping("/lifeManage")
public class SgPlanController {
    @Autowired
    private SgPlanService sgPlanService;

    /**
     * 计划制定
     *
     * @param sgPlan 计划内容
     * @return Result
     */
    @PostMapping("/insertPlan")
    public Result insertPlan(SgPlan sgPlan) {
        sgPlanService.insertPlan(sgPlan);
        return Result.success();
    }

    /**
     * 计划列表
     *
     * @param planName 计划名称
     * @param planDate 制定时间
     * @param userId   制定人
     * @param pageNum  当前页数
     * @param pageSize 每页记录数
     * @return Result
     */
    @PostMapping("/selectPlan")
    public Result selectPlan(
            @RequestParam(name = "planName",required = false) String planName,
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @RequestParam(name = "planDate",required = false) String planDate,
            @RequestParam(name = "userId",required = false) String userId,
            @RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") Integer pageSize) {
        return Result.success(sgPlanService.selectPlan(planName, planDate, userId, pageNum, pageSize));
    }
}
