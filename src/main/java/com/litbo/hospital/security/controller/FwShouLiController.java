package com.litbo.hospital.security.controller;

import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.bean.FwShouli;
import com.litbo.hospital.security.service.FwShouLiService;
import com.litbo.hospital.security.vo.FwShouLiIndexVo;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
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

            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            //String slrName = "";
            /*过时代码
            ShouliIndexVo shouliIndexVo = fwShouLiService.shouliIndex(fwId,userId);*/
            FwShouLiIndexVo fwShouLiIndexVo = fwShouLiService.shouLiIndexVo(fwId, userId);
            return Result.success(fwShouLiIndexVo);
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
            LiveEmpVo sEmp = (LiveEmpVo)SecurityUtils.getSubject().getSession().getAttribute("emp");
            String userId = sEmp.getUserId();
            List<String> fwIdList = fwShouLiService.getFWIdBySlrId(userId);
            return Result.success(fwIdList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("加载维修单号失败");
        }
    }
}
