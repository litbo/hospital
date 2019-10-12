package com.litbo.hospital.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.dao.MyMapper.EqTjsqMapper;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.SysGgxz;
import com.litbo.hospital.user.dao.GgDao;
import com.litbo.hospital.user.service.GgxzService;
import com.litbo.hospital.user.vo.DelGgxzVo;
import com.litbo.hospital.user.vo.ListVo;
import com.litbo.hospital.user.vo.SysGgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
*
* 公共下载
* @author : ljl
**/

/*@RestController*/
@RestController
@RequestMapping("/ggxz")
public class GgxzController {

    @Autowired
    GgxzService ggxzService;
    @Autowired
    EqTjsqMapper tjsqMapper;

    @Autowired
    GgDao dao;


    //添加公共下载
    @RequestMapping("/addGgxz")
    public Result addGgxz(@RequestBody SysGgxz ggxz){
       if(ggxzService.addGgxz(ggxz)>0){
           return Result.success();
       }

       return Result.error();
    }

    //查询公共下载
    @RequestMapping("/listGgxzs")
    public Result listGgxzs(@RequestParam(required = false,defaultValue="1") int pageNum,
                          @RequestParam(required = false,defaultValue="10") int pageSize) {
        PageInfo pageInfo = ggxzService.listGgxzs(pageNum, pageSize);
        return Result.success(pageInfo);
    }

    //查询待审核任务
    @RequestMapping("listWaits")
    public Result listWaits(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo pageInfo = ggxzService.listWaits(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    //通过审核
    @RequestMapping("/ggxzPass")
    public Result ggxzPass(Integer id){

        if(ggxzService.ggxzPass(id)>0) {
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @RequestMapping("/ggxzFail")
    public Result ggxzFail(Integer id){

        if(ggxzService.ggxzFail(id)>0){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @RequestMapping("/getGgxzById")
    public Result getGgxzById(Integer id){

        return Result.success(ggxzService.getGgxzById(id));
    }

    @RequestMapping("/getGgxzById2")
    public Result getGgxzById2(Integer id){
        SysGgVo vo = dao.selectGgDesc(id);
        vo.setGglxName(dao.selectGgTzLx(vo.getGglxId()));
       vo.setBmName(tjsqMapper.selectBmNameByBmid(vo.getBmId()));
        return Result.success(vo);
    }

    @RequestMapping("/delGgxz")
    @Transactional
    public Result delGgxz(@RequestBody DelGgxzVo ggxzVo){
        if(ggxzVo.getId()!=null){
            Integer integer = ggxzService.delGgxz(ggxzVo.getId());
            if(integer>0){
                return Result.success();
            }
            else{
                return Result.success("请选中数据");
            }
        }else {
            return Result.error();
        }

    }

}
