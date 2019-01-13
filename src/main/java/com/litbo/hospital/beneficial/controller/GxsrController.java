package com.litbo.hospital.beneficial.controller;

import com.litbo.hospital.beneficial.service.GxsrService;
import com.litbo.hospital.beneficial.vo.InsertSbcwVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/benefical/gxsr")
public class GxsrController {

    @Autowired
    private GxsrService gxsrService;

    @RequestMapping(value = "/insertSr",method = RequestMethod.POST)
    public Result insertSr(@RequestBody InsertSbcwVo insertSbcwVo){

        return gxsrService.insertSr(insertSbcwVo);
    }

    @RequestMapping(value = "/showSbSr",method = RequestMethod.POST)
    public Result ShowSbSr(@RequestParam("aId")Integer aId){

        return Result.success(gxsrService.showSbSr(aId));
    }

    @RequestMapping(value = "/updateSbSr",method = RequestMethod.POST)
    public Result updateSbSr(@RequestParam("aId")Integer aId, @RequestParam("kmValue") BigDecimal kmValue){

        if(gxsrService.updateSbSr(aId,kmValue)>0){
            return Result.success();
        }
        return  Result.error();
    }

    @RequestMapping(value = "/deleteSbSr",method = RequestMethod.POST)
    public Result deleteSbSr(@RequestParam("aId")Integer aId){

        if(gxsrService.deleteSbSr(aId)>0){
            return Result.success();
        }
        return  Result.error();
    }


}

