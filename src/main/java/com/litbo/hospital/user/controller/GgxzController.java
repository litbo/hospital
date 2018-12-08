package com.litbo.hospital.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.SysGgxz;
import com.litbo.hospital.user.service.GgxzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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


    //添加公共下载
    @RequestMapping("/addGgxz")
    public Result addGgxz(@RequestParam("file") MultipartFile multipartFile , SysGgxz ggxz){
       if(ggxzService.addGgxz(multipartFile,ggxz)>0){
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



    @RequestMapping()
    public String to(){
        return "uploadimg.html";
    }
}
