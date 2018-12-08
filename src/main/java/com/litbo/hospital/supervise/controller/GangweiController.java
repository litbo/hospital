package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.service.GangweiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervise/gwgl")  //行政岗位管理
public class GangweiController {
    @Autowired
    private GangweiService gangweiService;


    @PostMapping("/saveGw")
    public Result saveGw(@RequestBody  SGangwei gw){
        gangweiService.saveGw(gw);
        return Result.success();
    }
    @GetMapping("/deleteGwByGwId")
    public Result deleteGwByGwId(@RequestParam String gw_id){
        gangweiService.deleteGwByGwId(gw_id);
        return Result.success();
    }
    @GetMapping("/listGws")
    public Result getGws(@RequestParam(value = "pageNum" ,required = false , defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize",required = false ,defaultValue = "10") int pageSize){
        PageInfo date = gangweiService.getGws(pageNum,pageSize);
        return Result.success(date);
    }
    @GetMapping("/getGwByGwId")
    public Result getGwsByGwId(@RequestParam(value = "pageNum" ,required = false , defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize",required = false ,defaultValue = "10") int pageSize,
                               @RequestParam String gw_id){
        SGangwei date = gangweiService.getGwsByGwId(pageNum,pageSize,gw_id);
        return Result.success(date);
    }

    @PostMapping("/updateGw")
    public Result updateGw(@RequestBody  SGangwei gw){
        gangweiService.updateGw(gw);
        return Result.success();
    }

}
