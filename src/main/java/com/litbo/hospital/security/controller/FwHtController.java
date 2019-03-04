package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwHt;
import com.litbo.hospital.security.service.FwHtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjc
 * @create 2018-11-29 19:40
 * 维修合同
 */
@RestController
@RequestMapping("/fwht")
public class FwHtController {

    @Autowired
    private FwHtService fwHtService;

    //维修合同添加
    @PostMapping("/add")
    public Result addFwHt(FwHt fwHt){
        try {
            int i = fwHtService.addFwHt(fwHt);
            if(i>0){
                return Result.success();
            }else{
                return Result.error("添加shibai");
            }
        }catch (Exception ex){
            return Result.error("添加shibai");
        }

    }

    @GetMapping("/list")
    public Result getAllFwHt(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                             
                             @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        Result result = fwHtService.getAllFwHt(pageNum, pageSize);
        return result;
    }

}
