package com.litbo.hospital.efficiency.controller;

import com.litbo.hospital.efficiency.service.KpiRankingService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: kpi数据排名计算Controller层
 * @author: sz
 * @date: 2019/8/4 14:37
 */
@RestController
@RequestMapping("/kpi/ranking")
public class KpiRankingController {

    @Autowired
    private KpiRankingService kpiRankingService;

    @RequestMapping("/selectChangeOpen")
    public Result selectChangeOpen(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){

        return Result.success(kpiRankingService.selectChangeOpen(pageNum, pageSize));
    }

    @RequestMapping("/selectChangeUsing")
    public Result selectChangeUsing(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){

        return Result.success(kpiRankingService.selectChangeOpen(pageNum, pageSize));
    }

    @RequestMapping("/selectChangeIdling")
    public Result selectChangeIdling(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){

        return Result.success(kpiRankingService.selectChangeIdling(pageNum, pageSize));
    }

    @RequestMapping("/selectChangeIdlTimes")
    public Result selectChangeIdlTimes(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){

        return Result.success(kpiRankingService.selectChangeIdlTimes(pageNum, pageSize));
    }

    @RequestMapping("/selectChangeIntegrity")
    public Result selectChangeIntegrity(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){

        return Result.success(kpiRankingService.selectChangeIntegrity(pageNum, pageSize));
    }

}
