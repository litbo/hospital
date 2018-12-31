package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwShouli;
import com.litbo.hospital.security.service.FwShouLiService;
import com.litbo.hospital.security.vo.ShouliIndexVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-06 9:36
 */
@RestController
@RequestMapping("/shouli")
public class FwShouLiController {

    @Autowired
    private FwShouLiService fwShouLiService;

    @GetMapping("/shouLiIndex")
    public Result shouliIndex(String fwId){
        try {
            /*Session session = SecurityUtils.getSubject().getSession();
            session.getAttribute("");
            session.getAttribute("");*/
            String userId = "1615925023";
            //String slrName = "";
            ShouliIndexVo shouliIndexVo = fwShouLiService.shouliIndex(fwId,userId);
            return Result.success(shouliIndexVo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("读取信息失败");
        }
    }

    @PostMapping("/addShouli")
    public Result addShouli(FwShouli fwShouli){
        try {
            fwShouLiService.addShouli(fwShouli);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    @GetMapping("/getFwIdBySlrId")
    public Result getFwIdBySlrId(){
        /**
         *SecurityUtils.getSubject().getSession().getAttribute("userId");
         */
        try {
            String userId = "1";
            List<String> fwIdList = fwShouLiService.getFWIdBySlrId(userId);
            return Result.success(fwIdList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("加载维修单号失败");
        }
    }
}
