package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.service.BmService;
import com.litbo.hospital.supervise.vo.BmSelectVO;
import com.litbo.hospital.supervise.vo.SetBmVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/supervise/bmgl")
@Api(tags = "部门管理")
public class BmController {

    @Autowired
    private BmService bmService;

    @GetMapping("/ztree")
    public String ToZtree(){
        return "ztreeBmDemo";
    }

    @GetMapping("/listBms")
    @ResponseBody
    public Result getBmList(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = bmService.getBmList(pageNum,pageSize);
        return Result.success(date);
    }

    @GetMapping("/getBmByOid")
    @ResponseBody
    public Result getBmByOid(@RequestParam String oid){
        SBm date = bmService.getBmByOid(oid);
        return Result.success(date);
    }

    @GetMapping("/listBmsByPid")
    @ResponseBody
    public Result getBmListByPid(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                 @RequestParam String pid){
        PageInfo date = bmService.getBmListByPid(pageNum,pageSize,pid);
        return Result.success(date);
    }

    @GetMapping("/listBmsByX")
    @ResponseBody
    public Result getBmListByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               BmSelectVO selectVo){
        PageInfo date = bmService.getBmListByX(pageNum,pageSize,selectVo);
        return Result.success(date);
    }



    @PostMapping("/saveBm")
    @ResponseBody
    public Result saveBm(@RequestBody SBm bm){
        bmService.saveBm(bm);
        return Result.success();
    }

    @GetMapping("/removeBmByOid")
    @ResponseBody
    public Result removeBmByOid(@RequestParam String oid){
        boolean flag = true;
        flag = bmService.isZJD(oid);
        if(!flag) return Result.error("删除部门必须为叶子部门！！");
        bmService.removeBmByOid(oid);
        return Result.success();
    }


    @PostMapping("/setBmBeto")
    @ResponseBody
    public Result setBmBeto(@RequestBody SetBmVO bmVO){
        boolean flag = true;
        flag = bmService.isAllZJD(bmVO.getObm_ids());
        //判断部门是否为叶子部门
        if(!flag) return Result.error("部门必须为叶子部门！！");
        //调整部门
        bmService.setBmsBeto(bmVO);
        return Result.success();
    }

    @GetMapping("/setBmBetoTest")
    @ResponseBody
    public Result setBmBetoTest(@RequestParam String obm_id, @RequestParam String new_pbm_id  ){

        bmService.setBmBeto(obm_id,new_pbm_id);
        return Result.success();
    }

    @PostMapping("/hfWxbm")
    @ResponseBody
    public Result hfWxbm(@RequestBody List<String> obmids){
        bmService.setWxbm(obmids,1);  // 1 为维修部门
        return Result.success();
    }

    @PostMapping("/qchfWxbm")
    @ResponseBody
    public Result qchfWxbm(@RequestBody List<String> obmids){
        bmService.setWxbm(obmids,0);  // 0 为非维修部门
        return Result.success();
    }

    //  获取叶子部门

    @GetMapping("/listGLBm")
    @ResponseBody
    public Result listGLBm(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){

        PageInfo yzBmList = bmService.getGLBmList(pageNum, pageSize);
        return Result.success(yzBmList);
    }


}
