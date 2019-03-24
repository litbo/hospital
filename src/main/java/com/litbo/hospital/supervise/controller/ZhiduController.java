package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SZhidu;
import com.litbo.hospital.supervise.dao.ZhiduDao;
import com.litbo.hospital.supervise.service.ZhiduService;
import com.litbo.hospital.supervise.vo.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervise/zdgl")
@Api(tags = "制度审核管理")
public class ZhiduController {

    @Autowired
    private ZhiduService zhiduService;
    @Autowired
    private ZhiduDao zhiduDao;


    @GetMapping("/listZds")
    public Result getZds(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = zhiduService.getZds(pageNum,pageSize);
        return Result.success(date);
    }

    @GetMapping("/getZdById")
    public Result getZdById(String zdId){
        SZhidu sZhidu = zhiduService.getZdById(zdId);
        return Result.success(sZhidu);
    }

    @GetMapping("/listZds2")
    public Result listZds2(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        List<SZhidu> zds = zhiduDao.getZds();
        return Result.success(zds);
    }

    @RequestMapping("/listZdsByTimeAndZdNameAndZt")
    public Result listZdsByTimeAndZdNameAndZt(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                              String startTime, String endTime, String zdName, String zdZt,String reFlag){
        PageInfo date = null;
        try {
            date = zhiduService.listZdsByTimeAndZdNameAndZt(pageNum,pageSize,startTime,endTime,zdName,zdZt,reFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(date);
    }

    @GetMapping("/listZdsByZdZt")
    public Result listZdsByZdZt(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,String zdZt){
        PageInfo date = zhiduService.listZdsByZdZt(pageNum,pageSize,zdZt);
        return Result.success(date);
    }

    @PostMapping("/saveZd")
    public Result saveZd(@RequestBody SZhidu zd){
        zhiduService.saveZd(zd);
        return Result.success();
    }
    @GetMapping("/deleteZd")
    public Result deteleZd(@RequestParam int zd_id){
        zhiduService.deteleZd(zd_id);
        return Result.success();
    }
    @PostMapping("/updateZd")
    public Result updateZd(@RequestBody SZhidu zd){
        zhiduService.updateZd(zd);
        return Result.success();
    }
    @PostMapping("/submit")
    public Result submit(@RequestBody ZhiduSubmitVO zhiduSubmitVO){
        //提交时 SZhidu对象包括信息 bmid  zdname  zdcontent  docurl  userid createTime
        zhiduService.submit(zhiduSubmitVO);
        return Result.success();
    }

    @PostMapping("/reSubmit")
    public Result reSubmit(@RequestBody ZhiduSubmitVO zhiduSubmitVO){
        zhiduService.reSubmit(zhiduSubmitVO);
        return Result.success();
    }

    @GetMapping("/listZdsByShr")
    public Result listZdsByShr(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               String shr_id){
        PageInfo date = zhiduService.listZdsByShr(pageNum,pageSize,shr_id);
        return Result.success(date);
    }
    //通过审核人id获取待审核的制度的信息
    @GetMapping("/getShDetailMgs")
    public Result getShDetailMgsByZdId(@RequestParam Integer zdId,@RequestParam String shrId){
        ZdShDetailMsg date = zhiduService.getShDetailMgsByZdId(zdId,shrId);
        return Result.success(date);
    }

    @GetMapping("/getShProcesses")
    public Result getShProcesses(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                 @RequestParam Integer zdId){
        PageInfo date = zhiduService.getShProcesses(pageNum,pageSize,zdId);
        return Result.success(date);
    }

    @PostMapping("/submitShMsg")
    public Result submitShMsg(@RequestBody ShMsgVO shMsgVO){

        zhiduService.submitShMsg(shMsgVO);
        return Result.success();
    }

    @PostMapping("/dpjSubmitMsg")
    public Result dpjSubmitMsg(@RequestBody ZpjSumbitVO zpjSumbitVO){
        zhiduService.dpjSubmitMsg(zpjSumbitVO);
        return Result.success();
    }


    @GetMapping("/getZpjMsgByZdId")
    public Result getZpjMsgByZdId(@RequestParam String zdId){
        ZpjMsgVO zpjMsgVO = zhiduService.getZpjMsgByZdId(zdId);


        return Result.success(zpjMsgVO);
    }
    @PostMapping("/dpjSubmitShMsg")
    public Result dpjSubmitShMsg(@RequestBody ShMsgVO shMsgVO){

        zhiduService.dpjSubmitShMsg(shMsgVO);
        return Result.success();
    }


}
