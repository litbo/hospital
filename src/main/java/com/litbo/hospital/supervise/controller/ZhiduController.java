package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.service.ZhiduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervise/zdgl")
public class ZhiduController {

    @Autowired
    private ZhiduService zhiduService;

    @GetMapping("listZds")
    public Result getZds(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = zhiduService.getZds(pageNum,pageSize);
        return Result.success(date);
    }
    @PostMapping("/saveZd")
    public Result saveZd(@RequestBody SZhidu zd){
        zhiduService.saveZd(zd);
        return Result.success();
    }
    @GetMapping("/deleteZd")
    public Result deteleZd(@RequestParam int zd_id){
        zhiduService.deteleZd(zd_id);
        return Result.success();
    }
    @PostMapping("/updateZd")
    public Result updateZd(@RequestBody SZhidu zd){
        zhiduService.updateZd(zd);
        return Result.success();
    }

    @PostMapping("/submit")
    public Result submit(@RequestBody SZhidu zd,@RequestBody String shr_id){
        zhiduService.submit(zd,shr_id);
        return Result.success();
    }
}
