package com.litbo.hospital.security.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwBaoxiu;
import com.litbo.hospital.security.service.FwBaoxiuService;
import com.litbo.hospital.security.vo.FwBaoxiuIndexVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author zjc
 * @create 2018-12-03 11:29
 * 报修
 */
@RestController
@RequestMapping("/baoxiu")
public class FwBaoxiuController {

    @Autowired
    private FwBaoxiuService
            fwBaoxiuService;

    @GetMapping("/baoxiuRw")
    public Result baoxiuRw(@RequestParam(required = false,defaultValue = "10") Integer pageSize,
                           @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        try {
            String userId = "1615925038";
            PageInfo pageInfo = fwBaoxiuService.baoxiuRw(userId, pageNum, pageSize);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }

    /**
     * 设备
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/baoxiuEq")
    public Result baoxiuEq(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                           @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                           @RequestParam(required = false) String bmName, @RequestParam(required = false) String eqName){
        try {
            String userId = "1615925023";
            System.out.println(eqName);
            PageInfo pageInfo = fwBaoxiuService.getBaoxiuEq(userId, pageSize, pageNum,bmName,eqName);
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

    @RequestMapping(value = "listWx",method = RequestMethod.POST)
    public Result listWx(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize" ,required = false,defaultValue="10")int pageSize){
        PageInfo pageInfo = fwBaoxiuService.listWx(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @RequestMapping(value = "listWxTitles",method = RequestMethod.POST)
    public Result listWxTitles(){
        String title ="[{'type': 'radio'}, "+
                "{field: 'fpDh', title: '维修单号'},"+
                "{field: 'eqName', title: '配件名称'},"+
                "{field: 'eqGg', title: '规格'},"+
                "{field: 'eqXh', title: '型号'},"+
                "{field: 'wxfCjrgf', title: '费用'},"+
                "{field: 'bmName', title: '部门'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }
}
