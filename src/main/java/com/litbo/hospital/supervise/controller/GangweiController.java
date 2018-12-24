package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.service.GangweiService;
import com.litbo.hospital.supervise.vo.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervise/gwgl")  //行政岗位管理
@Api(tags = "岗位和岗位职责管理")
public class GangweiController {
    @Autowired
    private GangweiService gangweiService;


    @PostMapping("/saveGw")
    public Result saveGw(@RequestBody  SGangwei gw){
        gangweiService.saveGw(gw);
        return Result.success();
    }
    @GetMapping("/deleteGwByGwId")
    public Result deleteGwByGwId(@RequestParam String gw_id){
        gangweiService.deleteGwByGwId(gw_id);
        return Result.success();
    }
    @GetMapping("/listGws")
    public Result getGws(@RequestParam(value = "pageNum" ,required = false , defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize",required = false ,defaultValue = "10") int pageSize){
        PageInfo date = gangweiService.getGws(pageNum,pageSize);
        return Result.success(date);
    }
    @GetMapping("/getGwByGwId")
    public Result getGwsByGwId(@RequestParam(value = "pageNum" ,required = false , defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize",required = false ,defaultValue = "10") int pageSize,
                               @RequestParam String gw_id){
        SGangwei date = gangweiService.getGwsByGwId(pageNum,pageSize,gw_id);
        return Result.success(date);
    }

    @GetMapping("/getGwsByGwZzZt")
    public Result getGwsByGwZzZt(@RequestParam(value = "pageNum" ,required = false , defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize",required = false ,defaultValue = "10") int pageSize,
                               @RequestParam Integer gwZzZt){
        PageInfo date = gangweiService.getGwsByGwZzZt(pageNum,pageSize,gwZzZt);

        return Result.success(date);
    }

    @PostMapping("/updateGw")
    public Result updateGw(@RequestBody  SGangwei gw){
        gangweiService.updateGw(gw);
        return Result.success();
    }

    @GetMapping("/readyResources")
    public Result readyResources(){
        GWReadyResourcesVO readyResourcesVO = gangweiService.readyResources();
        return Result.success(readyResourcesVO);
    }

    @PostMapping("/gwzzSubmit")
    public Result gwzzSubmit(@RequestBody GWSubmitVO gwSubmitVO){
        //提交时 SZhidu对象包括信息 bmid  zdname  zdcontent  docurl  userid createTime
        gangweiService.gwzzSubmit(gwSubmitVO);
        return Result.success();
    }

    @GetMapping("/listGwsByShr")
    public Result listZdsByShr(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               String shr_id,Integer gwZzZt){
        PageInfo date = gangweiService.listZdsByShr(pageNum,pageSize,shr_id);
        return Result.success(date);
    }

    //通过审核人id获取待审核的岗位的信息
    @GetMapping("/getShDetailMgs")
    public Result getShDetailMgsByZdId(@RequestParam Integer zdId,@RequestParam String shrId){
        GwShDetailMsg date = gangweiService.getShDetailMgsByZdId(zdId,shrId);
        return Result.success(date);
    }

    @PostMapping("/submitShMsg")
    public Result submitShMsg(@RequestBody ShMsgVO shMsgVO){

        gangweiService.submitShMsg(shMsgVO);
        return Result.success();
    }

    @GetMapping("/readyForXg")
    public Result readyForXgByGwId(@RequestParam Integer gwId){

        GwZzReadyForXgVO vo = gangweiService.readyForXgByGwId(gwId);
        return Result.success(vo);
    }

    @PostMapping("/reSubmit")
    public Result reSubmit(@RequestBody GWSubmitVO gwSubmitVO){
        gangweiService.reSubmit(gwSubmitVO);
        return Result.success();
    }
}
