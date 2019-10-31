package com.litbo.hospital.supervise.controller;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/pb")
public class PbController {

    @Autowired
    private PbService pbService;
    @RequestMapping("/pbPlan")
    public Result pbPlan( PbJhVO pbJhVO){
        pbService.addPbPlan(pbJhVO);
        return Result.success();
    }

    @RequestMapping("/getPbPlan")
    public Result getPbPlan(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        List<getPbPlanVos> pbPlanVosList = pbService.getPbPlan(pageNum,pageSize);
        if(pbPlanVosList!=null){
            return Result.success(new PageInfo(pbPlanVosList));
        }else{
            return Result.error("没有值班计划,请添加!");
        }
    }

    @RequestMapping("/getPbPeople")
    public Result getPbPeople(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              @RequestParam("pbJhid") String id, HttpSession session)
    {
        session.setAttribute("pb_id",id);
        System.out.println("点击考勤是的id"+session.getAttribute("pb_id").toString());
        List<RyVos> ryVos = pbService.getPbPeople(pageNum,pageSize,id);
        if(ryVos!=null){
            return Result.success(new PageInfo(ryVos));
        }else{
            return Result.error("没有值班人员,请添加!");
        }
    }

    @RequestMapping("/ghPeople")
    public Result ghPeople(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              HttpSession session)
    {
        String sid = session.getAttribute("pb_id").toString();
        System.out.println("点击更换时的id"+sid);
        List<RyVos> ryVos = pbService.ghPeople(pageNum,pageSize,sid);
        if(ryVos!=null){
            return Result.success(new PageInfo(ryVos));
        }else{
            return Result.error("没有值班人员,请添加!");
        }
    }

}
