package com.litbo.hospital.user.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.dao.CsDao;
import com.litbo.hospital.user.service.CsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cs")
public class CsController {

    @Autowired
    private CsService csService;


    @RequestMapping("/listScs")
    public Result listScs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = csService.listScs(pageNum,pageSize);
        return Result.success(date);
    }
        @RequestMapping("/listWxs")
    public Result listWxs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                          @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = csService.listWxs(pageNum,pageSize);
        return Result.success(date);
    }
    @RequestMapping("/listGys")
    public Result listGys(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                          @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo date = csService.listGys(pageNum,pageSize);
        return Result.success(date);
    }

    @PostMapping("scsTitle")
    public Result scsTitle() {
        String title ="[{'type': 'radio'}, "+
                "{field: 'scsName', title: '生产商'},"+
                "{field: 'sbcsLxr1', title: '联系人'},"+
                "{field: 'sbcsLxdh1', title: '联系电话'},"+
                "{field: 'email', title: 'Email地址'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }
    @PostMapping("wxsTitle")
    public Result wxsTitle() {
        String title ="[{'type': 'radio'}, "+
                "{field: 'wxsName', title: '维修商'},"+
                "{field: 'sbcsLxr1', title: '联系人'},"+
                "{field: 'sbcsLxdh1', title: '联系电话'},"+
                "{field: 'email', title: 'Email地址'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }
    @PostMapping("gysTitle")
    public Result gysTitle() {
        String title ="[{'type': 'radio'}, "+
                "{field: 'gysName', title: '供应商'},"+
                "{field: 'sbcsLxr1', title: '联系人'},"+
                "{field: 'sbcsLxdh1', title: '联系电话'},"+
                "{field: 'email', title: 'Email地址'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }
}
