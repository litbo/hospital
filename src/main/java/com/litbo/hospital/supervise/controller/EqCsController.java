package com.litbo.hospital.supervise.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.service.EqCsService;
import com.litbo.hospital.supervise.vo.EqCsInsertReadyVO;
import com.litbo.hospital.supervise.vo.EqCsSelectVO;
import com.litbo.hospital.user.bean.EqCs;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervise/csgl")
@Api(tags = "厂商管理")
public class EqCsController {
    @Autowired
    private EqCsService eqCsService;

    @PostMapping("/listEqCs")
    public Result listEqCs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = eqCsService.listEqCs(pageNum,pageSize);
        return Result.success(pageInfo);
    }
    @PostMapping("/listEqCs1")
    public Result listEqCs1(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = eqCsService.listEqCs1(pageNum,pageSize);
        return Result.success(pageInfo);
    }
    @GetMapping("/readyResource")
    public Result readyResource(){
        EqCsInsertReadyVO readyVO = eqCsService.readyResource();
        return Result.success(readyVO);
    }
    @PostMapping("/insertEqCs")
    public Result insertEqCs(@RequestBody EqCs eqCs){
        eqCsService.insertEqCs(eqCs);
        return Result.success();
    }

    @GetMapping("/listEqcsByX")
    @ResponseBody
    public Result listEqcsByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              EqCsSelectVO selectVo){
        PageInfo date = eqCsService.listEqcsByX(pageNum,pageSize,selectVo);
        return Result.success(date);
    }
    @PostMapping("eqcsTitles")
    public Result eqcsTitles() {
        String title ="[{'type': 'radio'}, "+
                "{field: 'sbcsName', title: '供货商'},"+
                "{field: 'sbcsLxr1', title: '联系人'},"+
                "{field: 'sbcsLxdh1', title: '联系电话'},"+
                "{field: 'email', title: 'Email地址'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }
}
