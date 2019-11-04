package com.litbo.hospital.supervise.controller;


import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.KqRyVos;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@ResponseBody
@RequestMapping("/pb")
public class PbController {

    @Autowired
    private PbService pbService;
    @RequestMapping("/pbPlan")  //下达排班计划
    public Result pbPlan( @RequestBody PbJhVO pbJhVO){
//        System.out.println(pbJhVO);
        ///System.out.println(pbJhVO.getUserId());
            pbService.addPbPlan(pbJhVO);
            return Result.success("添加成功");
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

    @RequestMapping("/getBmPeople") //得到科室人员
    public Result getBmpeople(@RequestParam("bmId") String bmId,
                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize){
//        System.out.println(bmId);
        String str = bmId.replaceAll("\\\"", "");
        return  Result.success(pbService.getBmpeople(str,pageNum,pageSize));

    }

    @RequestMapping("/getPbPeople")
    public Result getPbPeople(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              @RequestParam("pbJhid") String id, HttpSession session)
    {
        session.setAttribute("pb_id",id);
        //System.out.println("点击考勤是的id"+session.getAttribute("pb_id").toString());
        List<RyVos> ryVos = pbService.getPbPeople(pageNum,pageSize,id);
        if(ryVos!=null){
            return Result.success(new PageInfo(ryVos));
        }else{
            return Result.error("没有值班人员,请添加!");
        }
    }

    @RequestMapping("/BcKqRy")
    public Result BcKqRy(@RequestBody List<KqRyVos> pbRyVos,HttpSession session){
       // System.out.println("点击保存按钮时的id"+session.getAttribute("pb_id").toString());
        if(pbRyVos.size()<=0){
            return Result.error("请选择数据!");
        }else{
            pbService.BcKqRy(pbRyVos,session.getAttribute("pb_id").toString());
            return Result.success();
        }
    }

    @RequestMapping("/ghPeople")
    public Result ghPeople(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                              HttpSession session,@RequestParam("id") String user_id)
    {
        session.setAttribute("user_id",user_id);
        //System.out.println("点击更换传来的人员id:"+session.getAttribute("user_id").toString());
        String sid = session.getAttribute("pb_id").toString();
        //System.out.println("点击更换时的id"+sid);
        List<RyVos> ryVos = pbService.ghPeople(pageNum,pageSize,sid);
        if(ryVos!=null){
            return Result.success(new PageInfo(ryVos));
        }else{
            return Result.error("没有值班人员,请添加!");
        }
    }


    @RequestMapping("/tjPbRy")
    public Result tjPbRy(@RequestParam("userId") String uid,HttpSession session){
        //uid表示准备更换的人id,gid代表未到人员的id,sid表示未到人员的所在计划id

        String gid=session.getAttribute("user_id").toString();
        String sid = session.getAttribute("pb_id").toString();

        pbService.insertGhRy(uid,sid,gid);

       // System.out.println("点击更换弹出页面确定按钮时的人员id"+session.getAttribute("user_id").toString());
        return Result.success();
    }


}
