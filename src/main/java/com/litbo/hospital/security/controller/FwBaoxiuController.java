package com.litbo.hospital.security.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.service.FwBaoxiuService;
import com.litbo.hospital.security.vo.FwBaoxiuIndexVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjc
 * @create 2018-12-03 11:29
 * 报修
 */
@RestController
@RequestMapping("/baoxiu")
public class FwBaoxiuController {

    @Autowired
    private FwBaoxiuService fwBaoxiuService;

    @GetMapping("/baoxiuEq")
    public Result baoxiuEq(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                           @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        try {
            String userId = "1615925023";
            PageInfo pageInfo = fwBaoxiuService.getBaoxiuEq(userId, pageSize, pageNum);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息错误");
        }
    }

    /**
     * 报修页面
     * @param eqId
     * @return
     */
    @GetMapping("/baoxiuIndex")
    public Result baoxiuIndex(String eqId){
//        SecurityUtils.getSubject().getSession().getAttribute("");
        try {
            String userId = "1615925008";
            FwBaoxiuIndexVo baoxiuIndexVo = fwBaoxiuService.baoxiuIndex(eqId, userId);
            return Result.success(baoxiuIndexVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("返回数据失败");
        }
    }

    /**
     * 添加报修单
     * @param fwBaoxiu
     * @return
     */
    @PostMapping("/addBaoxiu")
    public Result addBaoxiu(FwBaoxiu fwBaoxiu){
        try {
            fwBaoxiuService.addBaoxiu(fwBaoxiu);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }

    /**
     * 更改状态
     * @param id
     * @param baoxiuStatus
     * @return
     */
    @GetMapping("/updateBaoxiuStatus")
    public Result updateBaoxiuStatus(String id,Integer baoxiuStatus){
        try {
            fwBaoxiuService.updateBaoxiuStatusById(id,baoxiuStatus);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
    }
}
