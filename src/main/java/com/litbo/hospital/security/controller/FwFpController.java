package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwFp;
import com.litbo.hospital.security.service.FwFpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("security/fw")
public class FwFpController {
    @Autowired
    private FwFpService fpService;
    @RequestMapping("listFwFp")
    public Result listFwFp(){
        PageInfo pageInfo = fpService.listFwFp();
        return Result.success(pageInfo);
    }
    @RequestMapping("insertFwFp")
    public Result insertFwFp(FwFp fp){
        Integer res = fpService.insertFwFp(fp);
        if(res==1){
            return Result.success();
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
}
