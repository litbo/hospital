package com.litbo.hospital.user.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.SysGg;
import com.litbo.hospital.user.dao.GgDao;
import com.litbo.hospital.user.service.GgService;
import com.litbo.hospital.user.vo.CheckVo;
import com.litbo.hospital.user.vo.DelVo;
import com.litbo.hospital.user.vo.ListVo;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
*
* 公告
* @author : ljl
**/
@RestController
@RequestMapping("/gg")
public class GgController {
    @Autowired
    private GgService ggService;
    //增加公告
    @RequestMapping("/addGg")
    public Result addGg(@RequestBody SysGg gg){
        gg.setStatus(0);
        if(ggService.addGg(gg)>0){
            return Result.success();
        }
        return Result.error();

    }

    //查询公告信息
    @RequestMapping("/listShowGg")
    public Result listGgs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                          @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = ggService.listShowGgs(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @RequestMapping("/listGgDesc")
    public Result listGgDesc(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = ggService.listGgDesc(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    //查询待审核公告
    @RequestMapping("listWaits")
    public  Result listWaits(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo =  ggService.listWaits(pageNum,pageSize);
        return Result.success(pageInfo);

    }

    //通过审核
    @RequestMapping("/checkGg")
    public Result checkGg(@RequestBody CheckVo chids){
        if(chids.getId()!=null){
            Integer integer = ggService.checkGg(chids.getId());
            if(integer>0){
                return Result.success();
            }else {
                return Result.error("请选中数据");
            }
        }else{
            return Result.error();
        }
    }

    //通过Id查询公告信息
    @RequestMapping("/getGgById")
    public Result getGgById(Integer id){

        return Result.success(ggService.getGgById(id));
    }

    //添加公告类别
    @RequestMapping("/addGglb")
    public Result addGglb(String gglxName){
        if(ggService.addGglb(gglxName)>0){
            return Result.success();
        }
        return Result.error();
    }
    //删除待审核公告
    @RequestMapping("/delGg")
    @Transactional
    public Result delGg(@RequestBody DelVo ggids){
        if(ggids.getId()!=null){
            Integer integer = ggService.delGg(ggids.getId());
            if (integer>0){
                return Result.success("已删除"+integer+"个公告");
            }else {
                return Result.error("请选中数据");
            }
        }else{
            return Result.error();
        }

    }

}
