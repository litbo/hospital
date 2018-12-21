package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.SgLccl;
import com.litbo.hospital.lifemanage.bean.vo.DateLowerAndUpperVO;
import com.litbo.hospital.lifemanage.bean.vo.SgLcclVO;
import com.litbo.hospital.lifemanage.service.SgLcclService;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 处置管理Controller
 *
 * @author Administrator on 2018-12-19
 */
@RestController
@RequestMapping("/lifeManage")
public class SgLcclController {
    @Autowired
    private SgLcclService sgLcclService;

    /**
     * 处置查询列表
     *
     * @param pageNum             当前页数
     * @param pageSize            每页显示记录数
     * @param dateLowerAndUpperVO 时间下限 时间上限
     * @return PageInfo<DisposalQueryVO>
     */
    @PostMapping("/selectSgLccLList")
    public Result selectSgLccLList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                   @RequestBody DateLowerAndUpperVO dateLowerAndUpperVO) {
        return Result.success(sgLcclService.selectSgLccLList(pageNum, pageSize, dateLowerAndUpperVO));
    }

    /**
     * 待报废清单
     *
     * @param pageNum    当前页数
     * @param pageSize   每页显示记录数
     * @param bmId       部门id
     * @param isScrapped 是否已报废 0 或 null未报废 1已报废
     * @return PageInfo<DisposalQueryVO>
     */
    @PostMapping("/selectScrappedList")
    public Result selectScrappedList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     @RequestParam(name = "bmId", required = false) String bmId,
                                     @RequestParam(name = "isScrapped", required = false) String isScrapped) {
        return Result.success(sgLcclService.selectScrappedList(pageNum, pageSize, bmId, isScrapped));
    }

    /**
     * 处置申请列表
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示记录数
     * @param bmId     部门id
     * @return PageInfo<DisposalQueryVO>
     */
    @PostMapping("/selectApplyList")
    public Result selectApplyList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(name = "bmId", required = false) String bmId) {
        return Result.success(sgLcclService.selectApplyList(pageNum, pageSize, bmId));
    }

    /**
     * 申请报废
     *
     * @param userId 用户id
     * @param eqId   设备id
     * @return Result
     */
    @PostMapping("/insertApplyScrap")
    public Result insertApplyScrap(@RequestParam(name = "userId") String userId, @RequestParam(name = "eqId") String eqId) {
        sgLcclService.insertApplyScrap(userId, eqId);
        return Result.success();
    }

    /**
     * 添加处置申请信息
     *
     * @param sgLcclVO 处置申请信息
     * @return Result
     */
    @PostMapping("/updateApply")
    public Result updateApply(@RequestBody SgLcclVO sgLcclVO) {
        sgLcclService.updateApply(sgLcclVO);
        return Result.success();
    }

    /**
     * 审核上报
     */
    @PostMapping("updateSgLccLByEqId")
    public Result updateSgLccLByEqId(@RequestBody SgLccl SgLccl){
        sgLcclService.updateSgLccLByEqId(SgLccl);
        return Result.success();
    }

}
