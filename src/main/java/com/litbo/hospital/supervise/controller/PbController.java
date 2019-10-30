package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/pb")
public class PbController {

    @Autowired
    private PbService pbService;
    @RequestMapping("/pbPlan")
    public Result pbPlan( PbJhVO pbJhVO){
        pbService.addPbPlan(pbJhVO);
        return Result.success();
    }

    @RequestMapping("getPbPlan")
    public Result getPbPlan(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        List<getPbPlanVos> pbPlanVosList = pbService.getPbPlan(pageNum,pageSize);
        if(pbPlanVosList!=null){
            return Result.success(new PageInfo(pbPlanVosList));
        }else{
            return Result.error("没有值班计划,请添加!");
        }
    }

}
