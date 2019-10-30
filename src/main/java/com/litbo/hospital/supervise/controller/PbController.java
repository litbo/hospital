package com.litbo.hospital.supervise.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.service.PbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pb")
public class PbController {

    @Autowired
    private PbService pbService;
    @RequestMapping("pbPlan")
    public Result pbPlan(@RequestBody PbJhVO pbJhVO){

        pbService.addPbPlan(pbJhVO);
        return Result.success();
    }
}
