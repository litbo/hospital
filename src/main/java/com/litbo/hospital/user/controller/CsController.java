package com.litbo.hospital.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.dao.CsDao;
import com.litbo.hospital.user.service.CsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("listScsByX")
    public Result listScsByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize, String sbcsName){
        PageInfo date = csService.listScsByX(pageNum,pageSize,sbcsName);
        return Result.success(date);


    }
    @RequestMapping("listWxsByX")
    public Result listWxsByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize, String sbcsName){
        PageInfo date = csService.listWxsByX(pageNum,pageSize,sbcsName);
        return Result.success(date);


    }
    @RequestMapping("listGysByX")
    public Result listGysByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                            @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize, String sbcsName){
        PageInfo date = csService.listGysByX(pageNum,pageSize,sbcsName);
        return Result.success(date);

    }

    @RequestMapping(value = "listScsSe",method = RequestMethod.POST)
    public Result listScsSe(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>查询</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/cs/listScsByX");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));
    }
    @RequestMapping(value = "listWxsSe",method = RequestMethod.POST)
    public Result listWxsSe(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>查询</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/cs/listWxsByX");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));
    }

    @RequestMapping(value = "listGysSe",method = RequestMethod.POST)
    public Result listGysSe(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>查询</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/cs/listGysByX");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));
    }

}
