package com.litbo.hospital.lifemanage.check.controller;

import com.litbo.hospital.lifemanage.bean.vo.ListIdsVO;
import com.litbo.hospital.lifemanage.check.pojo.Check;
import com.litbo.hospital.lifemanage.check.pojo.LoginInfo;
import com.litbo.hospital.lifemanage.check.service.CheckService;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Check")
public class ChekController {  //人工核对

    @Autowired
    public CheckService checkService;

    @RequestMapping(value = "/checkInfo" ) //账实核对列表
    @ResponseBody
    public Result checkInfo(@RequestParam(name = "plan_id") String plan_id,
                            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        return  Result.success(checkService.getCheck(plan_id,pageNum,pageSize));

    }
    @RequestMapping("/chek_yes")  //核对存在
    public Result chek_yes(@RequestBody LoginInfo id) {
        //获取登陆人id
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        checkService.updateStatus(id.getId(), emp.getUserId(), "1"); //存在为1. 不存在为0
        return Result.success();
    }

    @PostMapping("/chek_not")
    public Result chek_not(@RequestBody LoginInfo id) {
        //获取登陆人id
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        checkService.updateStatus(id.getId(), emp.getUserId(), "0");
        return Result.success();
    }




}
