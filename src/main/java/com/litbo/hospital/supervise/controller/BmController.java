package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/supervise/bmgl")
public class BmController {
    @Autowired
    private BmService bmService;

    @GetMapping("/ztree")
    public String ToZtree(){
        return "ztreeBmDemo";
    }

    @GetMapping("/listBms")
    @ResponseBody
    public Result getBmList(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = bmService.getBmList(pageNum,pageSize);
        return Result.success(date);
    }

    @GetMapping("/getBmsById")
    @ResponseBody
    public Result getBmListById(@RequestParam String bm_id){
        SBm date = bmService.getBmListById(bm_id);
        return Result.success(date);
    }

    @GetMapping("/listBmsByPid")
    @ResponseBody
    public Result getBmListByPid(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                 @RequestParam String pid){
        PageInfo date = bmService.getBmListByPid(pageNum,pageSize,pid);
        return Result.success(date);
    }

    @GetMapping("/listBmsByX")
    @ResponseBody
    public Result getBmListByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               BmSelectVO selectVo){
        PageInfo date = bmService.getBmListByX(pageNum,pageSize,selectVo);
        return Result.success(date);
    }

    @PostMapping("/saveBm")
    @ResponseBody
    public Result saveBm(@RequestBody SBm bm){
        bmService.saveBm(bm);
        return Result.success();
    }

    @GetMapping("/removeBm")
    @ResponseBody
    public Result removeBm(@RequestParam String bm_id){
        bmService.removeBm(bm_id);
        return Result.success();
    }

}
