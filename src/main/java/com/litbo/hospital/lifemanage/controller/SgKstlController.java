package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgKstl;
import com.litbo.hospital.lifemanage.service.SgKstlService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 科室讨论表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgKstlController {
    @Autowired
    private SgKstlService sgKstlService;

    /**
     * 添加科室讨论信息
     *
     * @param sgKstl  科室讨论实体对象
     * @param usersId 参加讨论的人员集合
     * @param pmId    设备品名ID
     * @return 添加科室讨论信息成功/添加科室讨论信息失败
     */
    @PostMapping("/insertSgKstl")
    public Result insertSgKstl(@RequestBody SgKstl sgKstl, @RequestParam(name = "usersId") List<String> usersId, @RequestParam(name = "pmId") List<Integer> pmId){
        boolean result = sgKstlService.insertSgKstl(sgKstl, usersId, pmId);
        if (result){
            return Result.success();
        }else {
            return Result.error("添加信息错误");
        }
    }

}
