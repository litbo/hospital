package com.litbo.hospital.security.controller;


import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.PxDelAndSelService;
import com.litbo.hospital.security.vo.EmpVo;
import com.litbo.hospital.security.vo.LSRyVo;
import com.litbo.hospital.security.vo.TjRyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/selRyjh")
    public Result selRyjh(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize,String name){
        PageInfo pageInfo = pxDelAndSelService.selRyjh(pageNum,pageSize,name);
        return Result.success(pageInfo);
    }

    @RequestMapping("/selYyjh")
    public Result selYyjh(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize,String name){
        PageInfo pageInfo = pxDelAndSelService.selRyjh(pageNum,pageSize,name);
        return Result.success(pageInfo);
    }

    @RequestMapping("/getRyBtNr")
    public Result getRyBtNr(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        List<EmpVo> list = pxDelAndSelService.getRyBtNr(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        return Result.success(pageInfo);
    }

    @RequestMapping("/selectRy")
    public Result selectRy(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        List<TjRyVo> list = pxDelAndSelService.selectRy(pageNum,pageSize);
        return Result.success(new PageInfo(list));
    }

    @RequestMapping("/insertRy")
        public Result insertRy(@RequestBody LSRyVo lsRyVo){
        TjRyVo[] tjRyVos = lsRyVo.getTjRyVos();
        for(TjRyVo tjRyVo:tjRyVos){
           pxDelAndSelService.insertRy(tjRyVo);//
        }
        return Result.success();
    }

}
