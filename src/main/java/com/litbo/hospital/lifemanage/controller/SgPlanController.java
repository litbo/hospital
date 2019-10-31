package com.litbo.hospital.lifemanage.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.DelVO;
import com.litbo.hospital.lifemanage.bean.ListNum;
import com.litbo.hospital.lifemanage.bean.SgPlan;
import com.litbo.hospital.lifemanage.bean.vo.SgPlanVO;
import com.litbo.hospital.lifemanage.service.SelectService;
import com.litbo.hospital.lifemanage.service.SgPlanService;
import com.litbo.hospital.result.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private SelectService selectService;
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
     * @param userName   制定人
     * @param pageNum  当前页数
     * @param pageSize 每页记录数
     * @return Result
     */
    @RequestMapping(  value = "/selectPlan")
    @ResponseBody
    public Result selectPlan(
            @RequestParam(name = "planName",required = false) String planName,
            @RequestParam(name = "planDate",required = false) String planDate,
            @RequestParam(name = "userName",required = false) String userName,
            @RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue="15") int pageSize)
    {
        PageInfo pageInfo = sgPlanService.selectPlan(planName, planDate, userName, pageNum, pageSize);

        return Result.success(pageInfo);

    }

    /**
     * 查询所有的计划名字
     * @return
     */
    @GetMapping("/getplanName")
    public Result getplanName(){
        return Result.success(sgPlanService.getplanName());
    }

    /**
     * 根据计划名称查询计划id
     */
    @PostMapping("/selectIdByName")
    public Result selectIdByName(@RequestBody SgPlanVO sgPlanVO){
        return Result.success(sgPlanService.selectIdByName(sgPlanVO));
    }

    @RequestMapping("delPlan")
    public Result delPlan(@RequestBody DelVO ids){
        String planId [] =ids.getIds();
        for (int i=0; i<ids.getIds().length; i++){
            sgPlanService.delPlan(planId[i]);
//            System.out.println(planId[i]);
        }
        return  Result.success();
    }
}
