package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.vo.*;
import com.litbo.hospital.lifemanage.service.SgInfoService;
import com.litbo.hospital.lifemanage.service.SgYbghhyService;
import com.litbo.hospital.lifemanage.service.SgZbwyhhyService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 申购单表Controller
 */
@RestController
@RequestMapping("/lifeManage")
public class SgInfoController {
    @Autowired
    SgInfoService sgInfoService;
    @Autowired
    SgZbwyhhyService sgZbwyhhyService;
    @Autowired
    SgYbghhyService sgYbghhyService;

    /**
     * 通过申购单主键查询申购单信息
     *
     * @param sgInfoId 申购单主键
     * @return Result
     */
    @PostMapping("/selectSgInfoById")
    public Result selectSgInfoById(@RequestParam(name = "sgInfoId") String sgInfoId) {
        return Result.success(sgInfoService.selectSgInfoById(sgInfoId));
    }

    /**
     * 添加申购单信息、参考设备信息、功能配置信息
     *
     * @param sgInfoVO 申购单信息
     * @return Result
     */
    @PostMapping("insertSgInfo")
    public Result insertSgInfo(@RequestBody SgInfoVO sgInfoVO) {
        sgInfoService.insertSgInfo(sgInfoVO);
        return Result.success();
    }


    /**
     * 显示申购单科室审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param userId               登陆人id
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @PostMapping("/selectSgInfoKsshList")
    public Result selectSgInfoKsshList(@RequestBody SgInfoSumAuditListVO sgInfoSumAuditListVO,
                                       @RequestParam(name = "userId") String userId,
                                       @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoKsshList(sgInfoSumAuditListVO, userId, pageNum, pageSize));
    }

    /**
     * 科室审核
     *
     * @param shVO 科室审核表单VO
     * @return Result
     */
    @PostMapping("updateSgInfoKssh")
    public Result updateSgInfoKssh(@RequestBody ShVO shVO) {
        sgInfoService.updateSgInfoKssh(shVO);
        return Result.success();
    }

    /**
     * 显示申购单工程处审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @PostMapping("/selectSgInfoGccshList")
    public Result selectSgInfoGccshList(@RequestBody SgInfoSumAuditListVO sgInfoSumAuditListVO,
                                        @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoGccshList(sgInfoSumAuditListVO, pageNum, pageSize));
    }

    /**
     * 医学工程处审核
     *
     * @param shVO 医学工程处审核表单VO
     * @return Result
     */
    @PostMapping("updateSgInfoYxgccsh")
    public Result updateSgInfoYxgccsh(@RequestBody ShVO shVO) {
        sgInfoService.updateSgInfoYxgccsh(shVO);
        return Result.success();
    }

    /**
     * 显示申购单装备委员会审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @PostMapping("/selectSgInfoSgZbwyhhyList")
    public Result selectSgInfoSgZbwyhhyList(@RequestBody SgInfoSumAuditListVO sgInfoSumAuditListVO,
                                            @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoSgZbwyhhyList(sgInfoSumAuditListVO, pageNum, pageSize));
    }

    /**
     * 装备委员会审核
     *
     * @param sgZbwyhhyVO 审核表单VO
     * @return Result
     */
    @PostMapping("updateSgInfoZbwyhhy")
    public Result updateSgInfoZbwyhhy(@RequestBody SgZbwyhhyVO sgZbwyhhyVO) {
        ShVO shVO = new ShVO();
        BeanUtils.copyProperties(sgZbwyhhyVO, shVO);
        sgInfoService.updateSgInfoZbwyhhy(shVO);
        sgZbwyhhyService.insertSgInfoZbwyhhy(sgZbwyhhyVO);
        return Result.success();
    }

    /**
     * 显示申购单院办公室审核列表
     *
     * @param sgInfoSumAuditListVO 条件信息
     * @param pageNum              页数
     * @param pageSize             每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @PostMapping("/selectSgInfoYbgsShList")
    public Result selectSgInfoYbgsShList(@RequestBody SgInfoSumAuditListVO sgInfoSumAuditListVO,
                                         @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoYbgsShList(sgInfoSumAuditListVO, pageNum, pageSize));
    }

    /**
     * 院办公会审核
     *
     * @param sgYbghhyVO 审核表单VO
     * @return Result
     */
    @PostMapping("updateSgInfoYbghhy")
    public Result updateSgInfoYbghhy(@RequestBody SgYbghhyVO sgYbghhyVO) {
        ShVO shVO = new ShVO();
        BeanUtils.copyProperties(sgYbghhyVO, shVO);
        sgInfoService.updateSgInfoYbghhy(shVO);
        sgYbghhyService.insertSgInfoYbghhy(sgYbghhyVO);
        return Result.success();
    }

    /**
     * 查询满足论证分析的申购单
     *
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return Result
     */
    @PostMapping("selectSgInfoLzfx")
    public Result selectSgInfoLzfx(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoLzfx(pageNum, pageSize));
    }
}
