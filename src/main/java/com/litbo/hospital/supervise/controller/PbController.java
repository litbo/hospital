package com.litbo.hospital.supervise.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.poi.ImportExcelUtil;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.bean.KaoqinVO;
import com.litbo.hospital.supervise.bean.PbJhVO;
import com.litbo.hospital.supervise.service.PbService;
import com.litbo.hospital.supervise.vo.RyVos;
import com.litbo.hospital.supervise.vo.TjPbRyVos;
import com.litbo.hospital.supervise.vo.getPbPlanVos;
import com.litbo.hospital.user.bean.EqFj;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

import static com.litbo.hospital.common.utils.poi.ListToListMap.listToMap;
import static com.litbo.hospital.common.utils.poi.ListToListMap.parseMap2Object;

@Controller
@ResponseBody
@RequestMapping("/pb")
public class PbController {

    @Autowired
    private PbService pbService;
    @RequestMapping("/pbPlan")  //下达排班计划
    public Result pbPlan( @RequestBody PbJhVO pbJhVO){
//        System.out.println(pbJhVO);
        if (pbJhVO.getUserId()==null){
            return Result.error("人员为空！");
        }else {
            pbService.addPbPlan(pbJhVO);
            return Result.success("添加成功");
        }
    }

    @RequestMapping("getPbPlan")
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
        System.out.println("点击考勤是的id"+session.getAttribute("pb_id").toString());
        List<RyVos> ryVos = pbService.getPbPeople(pageNum,pageSize,id);
        if(ryVos!=null){
            return Result.success(new PageInfo(ryVos));
        }else{
            return Result.error("没有值班人员,请添加!");
        }
    }

    @RequestMapping("/BcKqRy")
    public Result BcKqRy(@RequestBody TjPbRyVos[] pbRyVos,HttpSession session){
        System.out.println("点击保存按钮时的id"+session.getAttribute("pb_id").toString());
        pbService.BcKqRy(pbRyVos,session.getAttribute("pb_id").toString());
        return Result.success();
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
