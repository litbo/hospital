package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.JhRylr;
import com.litbo.hospital.security.bean.JhZd;
import com.litbo.hospital.security.service.JhZdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjc
 * @create 2018-11-29 15:02
 * 计划
 */
@RestController
@RequestMapping("/Jh")
public class JhZdController {

    @Autowired
    private JhZdService jhZdService;

    @PostMapping("/jhAdd")
    public Result addJhZd(@RequestBody JhZd jhZd){
        Result result = jhZdService.addJhZd(jhZd);
        return result;
    }

    @GetMapping("/jhList")
    public Result getAllJhZd(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                             @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                             @RequestParam(required = false) String createdate, @RequestParam(value = "jhName",required = false) String jhName){

        Result result = jhZdService.listJhZd(pageNum, pageSize,createdate,jhName);
        return result;
    }

    @PostMapping("/addJhry")
    public Result addJhRyLr(JhRylr jhRylr,String[] userIds){
        try {
            jhZdService.addJhRyLr(jhRylr,userIds);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("添加失败");
        }

    }

}
