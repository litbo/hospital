package com.litbo.hospital.user.controller;


import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.SysTxcl;
import com.litbo.hospital.user.bean.SysTxlb;
import com.litbo.hospital.user.dao.XttxDao;
import com.litbo.hospital.user.service.XttxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//系统提醒
@RestController
@RequestMapping("xttx")
public class XttxController {
    @Autowired
    private XttxService xttxService;
    @Autowired
    private XttxDao xttxDao;
    @RequestMapping("addTxlb")
    public Result addTxlb(@RequestBody SysTxlb sysTxlb){
        if(xttxService.addTxlb(sysTxlb)>0){
            return Result.success();
        }
        return Result.error();
    }

    @RequestMapping("addTxcl")
    public Result addTxcl(@RequestBody SysTxcl sysTxcl){
        if(xttxService.addTxcl(sysTxcl)>0){
            return Result.success();
        }
        return Result.error();
    }

    @RequestMapping("/listTxlb")
    public Result listTxlb(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        return Result.success(xttxService.listTxlb(pageNum,pageSize));
    }

    @RequestMapping("/listTxlbNoLimit")
    public Result listTxlbNoLimit() {
        return Result.success(xttxDao.listTxlb());
    }

    @RequestMapping("/listTxcl")
    public Result listTxcl(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {

        return Result.success(xttxService.listTxcl(pageNum,pageSize));
    }


}
