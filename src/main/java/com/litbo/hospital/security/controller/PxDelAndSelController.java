package com.litbo.hospital.security.controller;


import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.security.service.PxDelAndSelService;
import com.litbo.hospital.security.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/px")
public class PxDelAndSelController {

    @Autowired(required = false)
    PxDelAndSelService pxDelAndSelService;


    @RequestMapping("/selByName")
    public Result selByName(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
        @RequestParam("rName") String rName,HttpSession session){
        String id=session.getAttribute("jh_id").toString();
        PageInfo pageInfo = pxDelAndSelService.selByName(pageNum,pageSize,rName,id);
        return Result.success(pageInfo);
    }

    @RequestMapping("/delYyjh")
    public Result delYyjh(@RequestBody StringVo stringVo){
        if(stringVo.getId()!=null){
            Integer integer = pxDelAndSelService.DelYyjh(stringVo.getId());
            if(integer > 0){
                return Result.success();
            }else {
                return Result.error("请选中数据");
            }
        }else{
            return Result.error();
        }
    }

    @RequestMapping("/selYyjh")
    public Result selYyjh(@RequestParam(value = "pageNum",required = false, defaultValue = "1")
                                      int pageNum,@RequestParam(value = "pageSize",required = false,
                                        defaultValue = "10") int pageSize,@RequestParam("name") String name){
        PageInfo pageInfo = pxDelAndSelService.selYyjh(pageNum,pageSize,name);
        return Result.success(pageInfo);
    }

    @RequestMapping("/getRyBtNr")
    public Result getRyBtNr(@RequestParam(value = "pageNum",required = false, defaultValue = "1")
                            int pageNum,@RequestParam(value = "pageSize",required = false, defaultValue = "15") int pageSize,
                            @RequestParam("id") String id,HttpSession session){
        session.setAttribute("jh_id",id);
        //System.out.println("传送"+id);
        List<EmpVo> list = pxDelAndSelService.getRyBtNr(pageNum,pageSize,id);
        PageInfo pageInfo = new PageInfo(list);
        return Result.success(pageInfo);
    }

    @RequestMapping("/selectRy")
    public Result selectRy(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize){
        List<TjRyVo> list = pxDelAndSelService.selectRy(pageNum,pageSize);
        return Result.success(new PageInfo(list));
    }

    @RequestMapping("/insertRy")
    public Result insertRy(@RequestBody LSRyVo lsRyVo,HttpSession session){
//        System.out.println("map中的集合"+map.get("jh_jd").toString());
        //System.out.println("添加人员时:"+session.getAttribute("jh_id"));
        String id = session.getAttribute("jh_id").toString();
        //System.out.println("String  :::"+id);
        TjRyVo[] tjRyVos = lsRyVo.getTjRyVos();
        for(TjRyVo tjRyVo:tjRyVos){
            pxDelAndSelService.insertRy(tjRyVo,id);
        }

        return Result.success();
    }

    @RequestMapping("/findAllRy")
    public Result findAllRy(@RequestParam(value = "pageNum",required = false, defaultValue = "1") int pageNum,@RequestParam(value = "pageSize"
            ,required = false, defaultValue = "15") int pageSize,@RequestParam("id") String id){
       //System.out.println("详情++++"+id);
        PageInfo pageInfo = pxDelAndSelService.findAllRy(pageNum,pageSize,id);
        return Result.success(pageInfo);
    }

}
