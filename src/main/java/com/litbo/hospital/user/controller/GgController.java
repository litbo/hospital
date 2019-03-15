package com.litbo.hospital.user.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.SysGg;
import com.litbo.hospital.user.service.GgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
*
* 公告
* @author : ljl
**/
@RestController
@RequestMapping("/gg")
public class GgController {
    @Autowired
    private GgService ggService;

    //增加公告
    @RequestMapping("/addGg")
    public Result addGg(@RequestBody SysGg gg){
        gg.setStatus(0);
        if(ggService.addGg(gg)>0){
            return Result.success();
        }
        return Result.error();

    }

    //查询公告信息
    @RequestMapping("/listShowGg")
    public Result listGgs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                          @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = ggService.listShowGgs(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    //查询待审核公告
    @RequestMapping("listWaits")
    public  Result listWaits(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo =  ggService.listWaits(pageNum,pageSize);
        return Result.success(pageInfo);

    }

    //通过审核
    @RequestMapping("/checkGg")
    public Result checkGg(Integer id){
        if(ggService.checkGg(id)>0){
            return Result.success();
        }
        return Result.error();

    }

    //通过Id查询公告信息
    @RequestMapping("/getGgById")
    public Result getGgById(Integer id){

        return Result.success(ggService.getGgById(id));
    }

    //添加公告类别
    @RequestMapping("/addGglb")
    public Result addGglb(String gglxName){
        if(ggService.addGglb(gglxName)>0){
            return Result.success();
        }
        return Result.error();
    }

}
