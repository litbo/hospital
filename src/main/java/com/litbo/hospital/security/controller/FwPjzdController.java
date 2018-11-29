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
    @RequestMapping(value = "/listFwPjzd",method = RequestMethod.GET)
    public Result listPjzd(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        return Result.success(pjzdService.listFwPjzd(pageNum,pageSize));
    }
    @RequestMapping("/insertFwPjzd")
    public Result insertFwPjzd(FwPjzd pjzd){
        System.out.println(pjzd);
        return Result.success(pjzdService.insertFwPjzd(pjzd));
    }
}
