package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwFk;
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

    @PostMapping("/addFwFk")
    public Result addFwFk(FwFk fwFk){
        try {
            int i = fwHtService.addFwFk(fwFk);
            if(i>0){
                return Result.success();
            }else{
                return Result.error("添加shibai");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("添加shibai");
        }

    }

    //维修合同添加
    @PostMapping("/add")
    public Result addFwHt(@RequestBody FwHt fwHt){
        try {
            int i = fwHtService.addFwHt(fwHt);
            if(i>0){
                return Result.success();
            }else{
                return Result.error("添加shibai");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return Result.error("添加shibai");
        }

    }

    @GetMapping("/list")
    public Result getAllFwHt(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                             
                             @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        Result result = fwHtService.getAllFwHt(pageNum, pageSize);
        return result;
    }

    @GetMapping("/htZfList")
    public Result getFwHtZf(@RequestParam(required = false,defaultValue = "1") Integer pageNum,

                             @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        try {
            PageInfo pageInfo = fwHtService.getHtZfList(pageNum, pageSize);
            return Result.success(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("合同查询失败");
        }
    }

    @GetMapping("/htzfIndex")
    public Result htzfIndex(String id){
        try {
            return Result.success(fwHtService.getHtVoById(id));
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("加载信息失败");
        }

    }

}
