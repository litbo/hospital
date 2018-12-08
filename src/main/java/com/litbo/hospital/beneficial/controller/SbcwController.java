package com.litbo.hospital.beneficial.controller;

import com.litbo.hospital.beneficial.service.SbcwService;
import com.litbo.hospital.beneficial.vo.CbMhVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/benefical")
public class SbcwController {

    @Autowired
    private SbcwService sbcwService;

    //查询设备财务直接成本信息列表
    @RequestMapping(value = "/listZjcb")
    public Result listZjcb(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        return Result.success(sbcwService.listZjcb(pageNum,pageSize));
    }

    //查询设备直接成本列表根据条件查询
    @RequestMapping(value = "/listZjcbByX")
    public Result listZjcbByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              CbMhVo cbMhVo){

        return Result.success(sbcwService.listZjcbByX(pageNum,pageSize,cbMhVo));
    }

    //查询设备财务直接成本信息列表
    @RequestMapping(value = "/listJjcb")
    public Result listJjcb(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        return Result.success(sbcwService.listJjcb(pageNum,pageSize));
    }

    //查询设备直接成本列表根据条件查询
    @RequestMapping(value = "/listJjcbByX")
    public Result listJjcbByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              CbMhVo cbMhVo){

        return Result.success(sbcwService.listJjcbByX(pageNum,pageSize,cbMhVo));
    }

    //查询设备财务收入信息列表
    @RequestMapping(value = "/listSr")
    public Result listSr(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        return Result.success(sbcwService.listSr(pageNum,pageSize));
    }

    //查询设备直收入信息列表根据条件查询
    @RequestMapping(value = "/listSrByX")
    public Result listSrByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              CbMhVo cbMhVo){

        return Result.success(sbcwService.listSrByX(pageNum,pageSize,cbMhVo));
    }

    //查询设备财务收入信息列表
    @RequestMapping(value = "/listXyFx")
    public Result listXyFx(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        return Result.success(sbcwService.listXyFx(pageNum,pageSize));
    }

    //查询设备直收入信息列表根据条件查询
    @RequestMapping(value = "/listXyFxByX")
    public Result listXyFxByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                            CbMhVo cbMhVo){

        return Result.success(sbcwService.listXyFxByX(pageNum,pageSize,cbMhVo));
    }


}
