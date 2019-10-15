package com.litbo.hospital.lifemanage.controller;
import com.litbo.hospital.lifemanage.service.SelectService;
import com.litbo.hospital.lifemanage.service.SgCheckService;
import com.litbo.hospital.result.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checkInfo")
public class SelectControllerA {
    @Autowired
    private SelectService selectService;


    @ResponseBody
    @RequestMapping("/existInfo") //已盘
    public Result existInfoController(@RequestParam("pdJhid")String pdJhid,
                                 @RequestParam("bmId") String bmId
            ,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum
            ,@RequestParam(value = "pageSize",defaultValue = "15")Integer pageSize){
        return Result.success(selectService.selectAll(pdJhid,bmId,pageNum,pageSize));
    }

    @ResponseBody
    @RequestMapping("/notExist")//盘亏的
    public Result noteExistController(@RequestParam("pdJhid")String pdJhid,
                                      @RequestParam("bmId") String bmId
            ,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum
            ,@RequestParam(value = "pageSize",defaultValue = "15")Integer pageSize){

        return Result.success(selectService.selectNot(pdJhid,bmId,pageNum,pageSize));

    }
    @ResponseBody
    @RequestMapping("/allList")//盘点计划的
    public Result allListController(@RequestParam("pdJhid")String pdJhid,
                                      @RequestParam("bmId") String bmId
            ,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum
            ,@RequestParam(value = "pageSize",defaultValue = "15")Integer pageSize){

        return Result.success(selectService.allList(pdJhid,bmId,pageNum,pageSize));

    }

    @ResponseBody
    @RequestMapping("/selectLess")//盘盈
    public Result selectLessController(@RequestParam("pdJhid")String pdJhid,
                                    @RequestParam("bmId") String bmId
            ,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum
            ,@RequestParam(value = "pageSize",defaultValue = "15")Integer pageSize){

        return Result.success(selectService.selectLess(pdJhid,bmId,pageNum,pageSize));

    }

    @ResponseBody
    @RequestMapping("/findInfo")  //查找全部
    public Result findAll(
            @RequestParam("eqName")String eqName,
            @RequestParam("pdJhid")String pdJhid,
            @RequestParam("pageNum")Integer pageNum,
            @RequestParam("pageSize")Integer pageSize
    ){
        return Result.success(selectService.findInfo(pdJhid,eqName,pageNum,pageSize));
    }

    @ResponseBody
    @RequestMapping("/findYipan") //查找已盘
    public Result findYipan(
            @RequestParam("eqName")String eqName,
            @RequestParam("pdJhid")String pdJhid,
            @RequestParam("pageNum")Integer pageNum,
            @RequestParam("pageSize")Integer pageSize
    ){ return Result.success(selectService.findYipan(pdJhid,eqName,pageNum,pageSize)); }

    @ResponseBody
    @RequestMapping("/findPanying")  //查找盘盈
    public Result findPanying(
            @RequestParam("eqName")String eqName,
            @RequestParam("pdJhid")String pdJhid,
            @RequestParam("pageNum")Integer pageNum,
            @RequestParam("pageSize")Integer pageSize
    ){ return Result.success(selectService.findPanying(pdJhid,eqName,pageNum,pageSize)); }

    @ResponseBody
    @RequestMapping("/findPankui")  //查找盘亏
    public Result findPankui(
            @RequestParam("eqName")String eqName,
            @RequestParam("pdJhid")String pdJhid,
            @RequestParam("pageNum")Integer pageNum,
            @RequestParam("pageSize")Integer pageSize
    ){ return Result.success(selectService.findPankui(pdJhid,eqName,pageNum,pageSize)); }


    @ResponseBody
    @RequestMapping("/listNum")
    public Result listNum(@RequestParam("pdJhid")String pdJhid
                            ,@RequestParam("pageNum")Integer pageNum,
                          @RequestParam("pageSize")Integer pageSize){
        return Result.success(selectService.listNum( pdJhid ,pageNum,pageSize));

    }
}
