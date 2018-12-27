package com.litbo.hospital.beneficial.controller;


import com.litbo.hospital.beneficial.service.BAccountService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *会计科目的增删改查
 * */

@RestController
@RequestMapping(value = "/benefical/account")
public class BAccountController {

    @Autowired
    private BAccountService bAccountService;

    /*
    * 成本科目列表
    * */
    @RequestMapping(value = "/listCbAccount")
    public Result listCbAccount(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
    @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return Result.success(bAccountService.listCbAccount(pageNum,pageSize));
    }

    /*
     * 收入科目列表
     * */
    @RequestMapping(value = "/listSrAccount")
    public Result listSrAccount(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return Result.success(bAccountService.listSrAccount(pageNum,pageSize));
    }

}
