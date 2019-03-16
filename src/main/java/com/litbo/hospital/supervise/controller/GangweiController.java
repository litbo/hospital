package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.SGangwei;
import com.litbo.hospital.supervise.dao.GangweiDao;
import com.litbo.hospital.supervise.service.GangweiService;
import com.litbo.hospital.supervise.vo.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervise/gwgl")  //行政岗位管理
@Api(tags = "岗位和岗位职责管理")
public class GangweiController {
    @Autowired
    private GangweiService gangweiService;

    @Autowired
    private GangweiDao gangweiDao;

    @PostMapping("/saveGw")
    public Result saveGw(@RequestBody  SGangwei gw){
        if(gw.getGwId()!=null){
            gangweiService.updateGw(gw);
        }else {
            gangweiService.saveGw(gw);
        }
        return Result.success();
    }
    @GetMapping("/deleteGwByGwId")
    public Result deleteGwByGwId(@RequestParam String gw_id){
        gangweiService.deleteGwByGwId(gw_id);
        return Result.success();
    }


    @PostMapping("/deleteGwByGwIds")
    public Result deleteGwByGwIds(@RequestBody String[] gwIds){
        for(String gwid:gwIds)
            gangweiService.deleteGwByGwId(gwid);
        return Result.success();
    }
    @GetMapping("/listGws")
    public Result getGws(@RequestParam(value = "pageNum" ,required = false , defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize",required = false ,defaultValue = "10") int pageSize){
        PageInfo date = gangweiService.getGws(pageNum,pageSize);
        return Result.success(date);
    }

    @GetMapping("/listGws2")
    public Result getGws2(){
        List<SGangwei> gws = gangweiDao.getGws();
        return Result.success(gws);
    }
    @RequestMapping("/listGwsByGwZt")
    public Result listGwsByGwZt(@RequestParam(value = "pageNum" ,required = false , defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize",required = false ,defaultValue = "10") int pageSize,String gwZt){
        PageInfo date = gangweiService.listGwsByGwZt(pageNum,pageSize,gwZt);
        return Result.success(date);
    }

    @RequestMapping("/listGwsByTimeAndZdNameAndZt")
    public Result listGwsByTimeAndZdNameAndZt(@RequestParam(value = "pageNum" ,required = false , defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize",required = false ,defaultValue = "10") int pageSize,String gwZt,
                                String startTime, String endTime, String gwName){
        PageInfo date = null;
        try {
            date = gangweiService.listGwsByTimeAndZdNameAndZt(pageNum,pageSize,startTime,endTime,gwName,gwZt);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(date);
    }

    //获取岗位列表通过级别和名称迷糊查询
    @RequestMapping("/listGwsByGwLevelAndGwName")
    public Result listGwsByGwLevelAndGwName(@RequestParam(value = "pageNum" ,required = false , defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize",required = false ,defaultValue = "10") int pageSize,String gwLevel,String gwName){
        PageInfo date = gangweiService.getGwsByGwLevelAndGwName(pageNum,pageSize,gwLevel,gwName);
        return Result.success(date);
    }
    @GetMapping("/getGwByGwId")
    public Result getGwsByGwId(@RequestParam String gwId){
        SGangwei date = gangweiService.getGwsByGwId(gwId);
        return Result.success(date);
    }

    @GetMapping("/getGwByGwLevel")
    public Result getGwByGwLevel(@RequestParam String gw_level){
        List<SGangwei> date = gangweiService.getGwByGwLevel(gw_level);
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
        if(shMsgVO.getNextShrId().equals("请选择")){
            shMsgVO.setNextShrId(null);
        }
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
