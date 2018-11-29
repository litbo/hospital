package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.CodeMsg;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwPjzd;
import com.litbo.hospital.security.service.FwPjzdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("security/fw")
public class FwPjzdController {
    @Autowired
    private FwPjzdService pjzdService;
    @RequestMapping("/listPjzd")
    public Result listPjzd(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(pjzdService.listPjzd());
        return Result.success(pageInfo);
    }
    @RequestMapping("/insertFwPjzd")
    public Result getAllFwPjzd(FwPjzd pjzd){
        try {
            Integer res = pjzdService.insetFwPjzd(pjzd);
            if(res == 1){
                return Result.success(null);
            }else {
                return Result.error(CodeMsg.SERVER_ERROR);
            }
        }catch (Exception e){
            return Result.error(CodeMsg.PARAM_ERROR);
        }
    }
}
