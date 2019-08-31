package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgLssq;
import com.litbo.hospital.lifemanage.service.SgLssqService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 临时采购授权表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgLssqController {
    @Autowired
    private SgLssqService sgLssqService;

    /**
     * 添加临时授权信息
     *
     * @param sgLssq 临时授权信息
     * @return Result
     */
    @PostMapping("/insertSgLssq")
    public Result insertSgLssq(SgLssq sgLssq) {
        sgLssqService.insertSgLssq(sgLssq);
        return Result.success();
    }

    /**
     * 查询临时授权信息
     *
     * @param ksId     科室id
     * @param isKsg    授权是否过期
     * @param pageNum  当前页数
     * @param pageSize 每页的记录数
     * @return Result
     */
    @PostMapping("/selectSgLssq")
    public Result selectSgLssq(@RequestParam(name = "ksId", required = false) String ksId,
                               @RequestParam(name = "isKsg", required = false) String isKsg,
                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(sgLssqService.selectSgLssq(ksId, isKsg, pageNum, pageSize));
    }
}
