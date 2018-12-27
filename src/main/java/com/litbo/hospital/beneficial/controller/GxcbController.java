package com.litbo.hospital.beneficial.controller;

import com.litbo.hospital.beneficial.service.GxcbService;
import com.litbo.hospital.beneficial.vo.InsertSbcwVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/*
*
* 增删改查设备成本
* */

@RestController
@RequestMapping(value = "/benefical/gxcb")
public class GxcbController {

    @Autowired
    private GxcbService gxcbService;

    @RequestMapping(value = "/insertCb",method = RequestMethod.POST)
    public Result insertCb(@RequestBody InsertSbcwVo insertSbcwVo){

        return gxcbService.insertCb(insertSbcwVo);
    }

    @RequestMapping(value = "/showSbCb",method = RequestMethod.POST)
    public Result showSbCb(@RequestParam("aId")Integer aId){

        return Result.success(gxcbService.showSbCb(aId));
    }

    @RequestMapping(value = "/updateSbCb",method = RequestMethod.POST)
    public Result updateSbCb(@RequestParam("aId")Integer aId, @RequestParam("kmValue") BigDecimal kmValue){

        if(gxcbService.updateSbCb(aId,kmValue)>0){
            return Result.success();
        }
        return  Result.error();
    }

    @RequestMapping(value = "/deleteSbCb",method = RequestMethod.POST)
    public Result deleteSbCb(@RequestParam("aId")Integer aId){

        if(gxcbService.deleteSbCb(aId)>0){
            return Result.success();
        }
        return  Result.error();
    }



}

