package com.litbo.hospital.efficiency.controller;


import com.litbo.hospital.efficiency.bean.LevelBean;
import com.litbo.hospital.efficiency.service.LevelService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  设置效率等级的利用率、闲置率的界限
 *   @Author: jz
 *   @Date: 2019/7/31 16:59
 */
@RestController
@RequestMapping(value = "/efficiency/level")
public class LevelController {

    @Autowired
    private LevelService levelService;

    @RequestMapping(value = "/updateLevel",method = RequestMethod.POST)
    public Result updateLevel(@RequestBody LevelBean levelBean){
        if (levelService.updateLevel(levelBean)>0){
            return Result.success(levelService.selectLevel());
        }
        return Result.error();
    }

    @RequestMapping(value = "/selectLevel",method = RequestMethod.POST)
    public Result selectLevel(){
        return Result.success(levelService.selectLevel());
    }

}