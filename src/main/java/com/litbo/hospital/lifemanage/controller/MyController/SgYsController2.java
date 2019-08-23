package com.litbo.hospital.lifemanage.controller.MyController;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgHzYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgJsYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgLcYsVO;
import com.litbo.hospital.lifemanage.bean.vo.MyVO.SgSwYsVO;
import com.litbo.hospital.lifemanage.bean.vo.SgYsListVO;
import com.litbo.hospital.lifemanage.service.MyService.SgYsService2;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lifeManage")
public class SgYsController2 {

    @Autowired
    private SgYsService2 service;

    /**查询本科室待商务验收设备*/
    @PostMapping("/sgWaitSwYsList")
    public Result sgWaitSwYsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false) String htid) {
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        PageInfo<SgYsListVO> info = service.sgWaitSwYsList(pageNum, pageSize, sEmp.getBmId(), htid);
        return Result.success(info);
    }

    @PostMapping("/sgWaitJsYsList")
    public Result sgWaitJsYsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer
                                         pageNum,
                                 @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false) String htid) {
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        PageInfo<SgYsListVO> info = service.sgWaitJsYsList(pageNum, pageSize, sEmp.getBmId(), htid);
        return Result.success(info);
    }

    @GetMapping("/sgWaitLcYsList")
    public Result sgWaitLcYsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer
                                         pageNum,
                                 @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false) String htid) {
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        PageInfo<SgYsListVO> info = service.sgWaitLcYsList(pageNum, pageSize, sEmp.getBmId(), htid);
        return Result.success(info);
    }

    @PostMapping("/sgWaitHzYsList")
    public Result sgWaitHzYsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer
                                         pageNum,
                                 @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false) String htid) {
        LiveEmpVo sEmp = (LiveEmpVo) SecurityUtils.getSubject().getSession().getAttribute("emp");
        PageInfo<SgYsListVO> info = service.sgWaitHzYsList(pageNum, pageSize, sEmp.getBmId(), htid);
        return Result.success(info);
    }

    @PostMapping("/insertSw")
    public Result insertSw(@RequestBody SgSwYsVO sw) {
        return Result.success(service.insertSw(sw));
    }

    @PostMapping("/insertJs")
    public Result insertSw(@RequestBody SgJsYsVO js) {
        return Result.success(service.insertJs(js));
    }

    @PostMapping("/insertLc")
    public Result insertSw(@RequestBody SgLcYsVO lc) {
        return Result.success(service.insertLc(lc));
    }

    @PostMapping("/insertHz")
    public Result insertHz(@RequestBody SgHzYsVO hz) {
        return Result.success(service.insertHz(hz));
    }
    @PostMapping("/sgBenBmSwYsList")
    public Result sgBenBmSwYsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(name = "ksid") String ksid,
                                  @RequestParam(name = "htid") String htid,
                                  @RequestParam(name = "xnsb")String xnsb) {

        return Result.success(service.sgBenBmSwYsList(pageNum,pageSize,ksid,htid,xnsb));
    }

    @PostMapping("/sgBenBmJsYsList")
    public Result sgBenBmJsYsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(name = "ksid") String ksid,
                                  @RequestParam(name = "htid") String htid,
                                  @RequestParam(name = "xnsb")String xnsb) {

        return Result.success(service.sgBenBmJsYsList(pageNum,pageSize,ksid,htid,xnsb));
    }


    @PostMapping("/sgBenBmLcYsList")


    public Result sgBenBmLcYsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(name = "ksid") String ksid,
                                  @RequestParam(name = "htid") String htid,
                                  @RequestParam(name = "xnsb")String xnsb) {

        return Result.success(service.sgBenBmLcYsList(pageNum,pageSize,ksid,htid,xnsb));
    }


    @PostMapping("/sgBenBmHzYsList")
    public Result sgBenBmHzYsList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                  @RequestParam(name = "ksid") String ksid,
                                  @RequestParam(name = "htid") String htid,
                                  @RequestParam(name = "xnsb")String xnsb) {

        return Result.success(service.sgBenBmHzYsList(pageNum,pageSize,ksid,htid,xnsb));
    }

    @PostMapping("/selectAllYsJl")
    public Result selectAllYsJl(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSzie", required = false, defaultValue = "10") Integer pageSize,
                                @RequestParam(name = "htid") String htid,
                                @RequestParam(name = "bmid")String bmid) {

        return Result.success(service.selectAllYsJl(pageNum,pageSize,htid,bmid));
    }


    @GetMapping("/selectAllBmIdAndName")
    public Result selectAllBmIdAndName() {

        return Result.success(service.selectAllBmIdAndName());
    }



}
