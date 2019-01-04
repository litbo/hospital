package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.service.SgCheckService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * 账实核对Controller
 *
 * @author Administrator on 2018-12-29
 */
@RestController
@RequestMapping("/lifeManage")
public class SgCheckController {
    @Autowired
    private SgCheckService sgCheckService;

    @PostMapping("/selectSgCheck")
    public Result selectSgCheck(@RequestParam(name = "planId")String planId,
                                @RequestParam(name = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        return Result.success(sgCheckService.selectSgCheck(planId,pageNum,pageSize));
    }

    @PostMapping("/updateSgCheckByIds")
    public Result updateSgCheckByIds(@RequestParam(name = "ids")List<String> ids,@RequestParam(name = "userId")String userId){
        sgCheckService.updateSgCheckByIds(ids,userId);
        return Result.success();
    }

}
