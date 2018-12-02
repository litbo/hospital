package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.service.SgTlPmService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 讨论申购设备关联表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgTlPmController {
    @Autowired
    SgTlPmService sgTlPmService;

    /**
     * 申购设备关联信息批量添加
     *
     * @param kstlId  科室讨论的ID
     * @param pmId 设备品名ID
     * @return 添加关联信息成功/添加关联信息失败
     */
    @PostMapping("insertSgTlPm")
    public Result insertSgTlPm(@RequestParam(name = "kstlId") String kstlId,@RequestParam(name = "pmId") List<Integer> pmId){
        System.out.println(kstlId);
        boolean insert = sgTlPmService.insertSgTlPm(kstlId, pmId);
        if (insert){
            return Result.success();
        }else {
            return Result.error("添加信息失败");
        }
    }
}
