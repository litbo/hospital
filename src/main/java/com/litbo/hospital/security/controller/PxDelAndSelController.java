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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/px")
public class PxDelAndSelController {

    @Autowired(required = false)
    PxDelAndSelService pxDelAndSelService;

    @RequestMapping("/selByName")
    public Result selByName(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize,
        @RequestParam("rName") String rName){
        PageInfo pageInfo = pxDelAndSelService.selByName(pageNum,pageSize,rName);
        return Result.success(pageInfo);
    }

    @RequestMapping("/delYyjh")
    public Result delYyjh(@RequestBody StringVo stringVo,HttpSession httpSessionsession){
       // System.out.println(httpSessionsession.getAttribute("id"));
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
    public Result selYyjh(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,
                          @RequestParam("name") String name,HttpSession session){
//        session.setAttribute("id",1234);
//        session.setAttribute("id","我们");
//        System.out.println(session.getAttribute("id"));
        PageInfo pageInfo = pxDelAndSelService.selYyjh(pageNum,pageSize,name);
        return Result.success(pageInfo);
    }

    @RequestMapping("/getRyBtNr")
    public Result getRyBtNr(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        List<EmpVo> list = pxDelAndSelService.getRyBtNr(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        return Result.success(pageInfo);
    }

    @RequestMapping("/selectRy")
    public Result selectRy(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        List<TjRyVo> list = pxDelAndSelService.selectRy(pageNum,pageSize);
        return Result.success(new PageInfo(list));
    }

    @RequestMapping("/insertRy")
    public Result insertRy(@RequestBody LSRyVo lsRyVo,@RequestParam("id") String id){
        TjRyVo[] tjRyVos = lsRyVo.getTjRyVos();
        for(TjRyVo tjRyVo:tjRyVos){
            pxDelAndSelService.insertRy(tjRyVo,id);
        }

        return Result.success();
    }

    @RequestMapping("/findAllRy")
    public Result findAllRy(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        PageInfo pageInfo = pxDelAndSelService.findAllRy(pageNum,pageSize);
        return Result.success(pageInfo);
    }

}
