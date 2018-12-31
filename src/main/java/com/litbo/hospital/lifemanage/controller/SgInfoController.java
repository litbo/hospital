package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.vo.SgInfoVO;
import com.litbo.hospital.lifemanage.bean.vo.SgYbghhyVO;
import com.litbo.hospital.lifemanage.bean.vo.SgZbwyhhyVO;
import com.litbo.hospital.lifemanage.bean.vo.ShVO;
import com.litbo.hospital.lifemanage.service.SgInfoService;
import com.litbo.hospital.lifemanage.service.SgYbghhyService;
import com.litbo.hospital.lifemanage.service.SgZbwyhhyService;
import com.litbo.hospital.result.Result;
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
    @PostMapping("/insertSgInfo")
    public Result insertSgInfo(@RequestBody SgInfoVO sgInfoVO) {
        sgInfoService.insertSgInfo(sgInfoVO);
        return Result.success();
    }


    /**
     * 显示申购单科室审核列表
     *
     * @param userId   登陆人id
     * @param eqPmName 设备名称
     * @param bh       申购单编号
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @PostMapping("/selectSgInfoKsshList")
    public Result selectSgInfoKsshList(
            @RequestParam(name = "userId") String userId,
            @RequestParam(name = "eqPmName", required = false) String eqPmName,
            @RequestParam(name = "bh", required = false) String bh,
            @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoKsshList(eqPmName, bh, userId, pageNum, pageSize));
    }

    /**
     * 科室审核
     *
     * @param shVO 科室审核表单VO
     * @return Result
     */
    @PostMapping("/updateSgInfoKssh")
    public Result updateSgInfoKssh(@RequestBody ShVO shVO) {
        sgInfoService.updateSgInfoKssh(shVO);
        return Result.success();
    }

    /**
     * 显示申购单工程处审核列表
     *
     * @param bmId     部门id
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @PostMapping("/selectSgInfoGccshList")
    public Result selectSgInfoGccshList(@RequestParam(required = false, name = "bmId") String bmId,
                                        @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoGccshList(bmId, pageNum, pageSize));
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
     * @param bmId     部门id
     * @param bh       申购单编号
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @PostMapping("/selectSgInfoSgZbwyhhyList")
    public Result selectSgInfoSgZbwyhhyList(@RequestParam(required = false, name = "bmId") String bmId,
                                            @RequestParam(required = false, name = "bh") String bh,
                                            @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoSgZbwyhhyList(bmId, bh, pageNum, pageSize));
    }

    /**
     * 装备委员会审核
     *
     * @param sgZbwyhhyVO 审核表单VO
     * @return Result
     */
    @PostMapping("/updateSgInfoZbwyhhy")
    public Result updateSgInfoZbwyhhy(@RequestBody SgZbwyhhyVO sgZbwyhhyVO) {
        ShVO shVO = sgZbwyhhyVO.getShVO();
        sgInfoService.updateSgInfoZbwyhhy(shVO);
        //添加装备委员会审核信息
        for (String sgId : shVO.getIds()) {
            sgZbwyhhyVO.setSgId(sgId);
            sgZbwyhhyService.insertSgInfoZbwyhhy(sgZbwyhhyVO);
        }
        return Result.success();
    }

    /**
     * 显示申购单院办公室审核列表
     *
     * @param bmId     部门id
     * @param bh       申购单编号
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return SgInfoSumAuditListVO
     */
    @PostMapping("/selectSgInfoYbgShList")
    public Result selectSgInfoYbgShList(@RequestParam(required = false, name = "bmId") String bmId,
                                        @RequestParam(required = false, name = "bh") String bh,
                                        @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoYbgsShList(bmId, bh, pageNum, pageSize));
    }

    /**
     * 院办公会审核
     *
     * @param sgYbghhyVO 审核表单VO
     * @return Result
     */
    @PostMapping("/updateSgInfoYbghhy")
    public Result updateSgInfoYbghhy(@RequestBody SgYbghhyVO sgYbghhyVO) {
        ShVO shVO = sgYbghhyVO.getShVO();
        sgInfoService.updateSgInfoYbghhy(shVO);
        //添加院办公会审核信息
        for (String sgId : shVO.getIds()) {
            sgYbghhyVO.setSgId(sgId);
            sgYbghhyService.insertSgInfoYbghhy(sgYbghhyVO);
        }
        return Result.success();
    }

    /**
     * 查询满足论证分析的申购单
     *
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return Result
     */
    @PostMapping("/selectSgInfoLzfx")
    public Result selectSgInfoLzfx(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoLzfx(pageNum, pageSize));
    }

    /**
     * 申购设备公示查询列表
     *
     * @param isSh     是否通过审核
     * @param bmId     部门id
     * @param bh       申购单编号
     * @param sbName   设备拼音码
     * @param pageNum  页数
     * @param pageSize 每页显示记录数
     * @return Result
     */
    @PostMapping("/selectSgInfoList")
    public Result selectSgInfoList(
            @RequestParam(required = false, name = "isSh") String isSh,
            @RequestParam(required = false, name = "bmId") String bmId,
            @RequestParam(required = false, name = "bh") String bh,
            @RequestParam(required = false, name = "sbName") String sbName,
            @RequestParam(required = false, name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, name = "pageSize", defaultValue = "10") Integer pageSize) {
        return Result.success(sgInfoService.selectSgInfoList(isSh,bmId,bh,sbName,pageNum,pageSize));
    }
}
