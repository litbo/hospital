package com.litbo.hospital.user.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.SysGg;
import com.litbo.hospital.user.service.GgService;
import com.litbo.hospital.user.vo.DelSjzdVo;
import com.litbo.hospital.user.vo.DelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    //模糊查询通过审核的信息,根据标题进行查询
    @RequestMapping("/listChGg")
    public Result listEqByX(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                            @RequestParam("search") String name) {
       PageInfo pageInfo = ggService.listChGg(pageNum,pageSize,name);
        return Result.success(pageInfo);
    }

    @RequestMapping("/delSjzd")
    public Result delSjzd(@RequestBody DelSjzdVo delSjzdVo){
        if(delSjzdVo.getIds()!=null){
            Integer integer = ggService.delSjzd(delSjzdVo.getIds());
            if (integer>0){
                return Result.success();
            }else {
                return Result.error("请选中数据");
            }
        }else{
            return Result.error();
        }
    }

    @RequestMapping("/listShowGglx")
    public Result listGglxs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = ggService.listShowGglxs(pageNum,pageSize);
        return Result.success(pageInfo);
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
    @RequestMapping("/listWaits")
    public  Result listWaits(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo =  ggService.listWaits(pageNum,pageSize);
        return Result.success(pageInfo);

    }

    //通过审核
    @RequestMapping("/checkGg")
    public Result checkGg(@RequestParam("id[]") Integer[] ids){
        if(ids.length>0){
            for(Integer id:ids){
                ggService.checkGg(id);
            }
            return Result.success();
        }else {
            return Result.error("请选中数据");
        }
    }

    //模糊查询公告信息
    @RequestMapping("/getGgByBt")
    public Result getByBname(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSiz,@RequestParam("search") String bName){
        PageInfo pageInfo = ggService.getGgByBname(pageNum,pageSiz,bName);
        return Result.success(pageInfo);
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
