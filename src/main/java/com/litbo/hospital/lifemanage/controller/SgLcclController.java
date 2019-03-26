package com.litbo.hospital.lifemanage.controller;

import com.litbo.hospital.lifemanage.bean.vo.DateLowerAndUpperVO;
import com.litbo.hospital.lifemanage.bean.vo.ListIdsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgLcclVO;
import com.litbo.hospital.lifemanage.service.SgLcclService;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
                                   DateLowerAndUpperVO dateLowerAndUpperVO) {
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
     * @param eqId 设备id
     * @return Result
     */
    @PostMapping("/insertApplyScrap")
    public Result insertApplyScrap(@RequestBody ListIdsVO eqId) {
        sgLcclService.insertApplyScrap(eqId);
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
        //获取登陆人id
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        sgLcclVO.setApprover(emp.getUserId());
        sgLcclService.updateApply(sgLcclVO);
        return Result.success();
    }

    /**
     * 处置上报
     */
    @PostMapping("/updateSgLccLByEqId1")
    public Result updateSgLccLByEqId1(@RequestBody SgLcclVO sgLccl) {
        //获取登陆人id
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        sgLccl.setReportPerson(emp.getUserId());
        sgLccl.setReportTime(new Date());
        sgLcclService.updateSgLccLByEqId(sgLccl);
        return Result.success();
    }

    /**
     * 处置批复
     */
    @PostMapping("/updateSgLccLByEqId2")
    public Result updateSgLccLByEqId2(@RequestBody SgLcclVO sgLccl) {
        //获取登陆人id
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        sgLccl.setRatify(emp.getUserId());
        sgLccl.setRatifyTime(new Date());
        sgLcclService.updateSgLccLByEqId(sgLccl);
        return Result.success();
    }

    /**
     * 处置清理
     */
    @PostMapping("/updateSgLccLByEqId3")
    public Result updateSgLccLByEqId3(@RequestBody SgLcclVO sgLccl) {
        //获取登陆人id
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        sgLccl.setClearPerson(emp.getUserId());
        sgLccl.setClearTime(new Date());
        sgLcclService.updateSgLccLByEqId(sgLccl);
        return Result.success();
    }

    /**
     * 处置备案
     */
    @PostMapping("/updateSgLccLByEqId4")
    public Result updateSgLccLByEqId4(@RequestBody SgLcclVO sgLccl) {
        //获取登陆人id
        LiveEmpVo emp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        sgLccl.setRecord(emp.getUserId());
        sgLccl.setRecordTime(new Date());
        sgLcclService.updateSgLccLByEqId4(sgLccl);
        return Result.success();
    }

    /**
     * 待X列表
     *
     * @param pageNum  当前页数
     * @param pageSize 每页显示记录数
     * @param tab      标记 1待上报列表 2待批复列表 3待清理设备 4待备案处置设备
     * @return PageInfo<DisposalReportListVO>
     */
    @PostMapping("/selectXList")
    public Result selectXList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(name = "tab") String tab) {
        return Result.success(sgLcclService.selectXList(pageNum, pageSize, tab));
    }

    /**
     * 处置流程信息查询
     *
     * @param eqId 设备id
     * @return Result
     */
    @PostMapping("/selectDisposalProcess")
    public Result selectDisposalProcess(@RequestParam(name = "eqId") String eqId) {
        return Result.success(sgLcclService.selectDisposalProcess(eqId));
    }
}
