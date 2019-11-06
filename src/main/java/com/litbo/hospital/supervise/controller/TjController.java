package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.service.TjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pb")
public class TjController {

    @Autowired(required = false)
    TjService tjService;

    @RequestMapping("/getInfo")
    public Result getInfo(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        PageInfo pageInfo = tjService.getInfo(pageNum,pageSize);
        return Result.success(pageInfo);
    }
}
