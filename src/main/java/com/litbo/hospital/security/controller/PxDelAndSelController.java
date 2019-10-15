package com.litbo.hospital.security.controller;


import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.PxDelAndSelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/px")
public class PxDelAndSelController {

    @Autowired(required = false)
    PxDelAndSelService pxDelAndSelService;

    @RequestMapping("/delRyjh")
    public Result delRyjh(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
       Integer integer =  pxDelAndSelService.DelRyjh(pageNum,pageSize);
       if(integer > 0){
           return Result.success();
       }else {
           return Result.error();
       }

    }

    @RequestMapping("/delYyjh")
    public Result delYyjh(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        Integer integer = pxDelAndSelService.DelYyjh(pageNum,pageSize);
        if(integer > 0){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
