package com.litbo.hospital.supervise.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.supervise.service.EqCsService;
import com.litbo.hospital.supervise.vo.EqCsInsertReadyVO;
import com.litbo.hospital.supervise.vo.EqCsSelectVO;
import com.litbo.hospital.user.bean.EqCs;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/supervise/csgl")
@Api(tags = "厂商管理")
public class EqCsController {
    @Autowired
    private EqCsService eqCsService;

    @PostMapping("/listEqCs")
    public Result listEqCs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        List<EqCs> eqCs = eqCsService.listEqCs(pageNum, pageSize);
        return Result.success(new PageInfo<>(eqCs));
    }
    @GetMapping("/readyResource")
    public Result readyResource(){
        EqCsInsertReadyVO readyVO = eqCsService.readyResource();
        return Result.success(readyVO);
    }
    @PostMapping("/insertEqCs")
    public Result insertEqCs(@RequestBody EqCs eqCs){
        eqCsService.insertEqCs(eqCs);
        return Result.success();
    }

    @RequestMapping("/listEqcsByX")
    @ResponseBody
    public Result listEqcsByX(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              EqCsSelectVO selectVo){
        PageInfo date = eqCsService.listEqcsByX(pageNum,pageSize,selectVo);
        return Result.success(date);
    }
    @RequestMapping(value = "listEqcsByXSe",method = RequestMethod.POST)
    public Result listEqcsByXSe(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>搜索</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/supervise/csgl/listEqcsByX");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));

    }
    //供应商
    @PostMapping("/listEqcsByX1")
    public Result listEqcsByX1(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              EqCsSelectVO selectVo){
        PageInfo date = eqCsService.listEqcsByX1(pageNum,pageSize,selectVo);
        return Result.success(date);
    }
    @RequestMapping(value = "listEqcsByX1Se",method = RequestMethod.POST)
    public Result listEqcsByX1Se(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>搜索</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/supervise/csgl/listEqcsByX1");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));
    }

    //生产商
    @PostMapping("/listEqcsByX2")
    public Result listEqcsByX2(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                              EqCsSelectVO selectVo){
        PageInfo date = eqCsService.listEqcsByX2(pageNum,pageSize,selectVo);
        return Result.success(date);
    }
    @RequestMapping(value = "listEqcsByX2Se",method = RequestMethod.POST)
    public Result listEqcsByX2Se(){
        Map map =new HashMap();
        map.put("dom","<div class='layui-inline'><input type=\"text\" name=\"sbcsName\" class=\"layui-input\" placeholder=\"厂商名称\" autocomplete=\"off\"></div>" +
                "    <div class='layui-input-inline mar10-0' align='center'>" +
                "<button class='layui-btn' data-type='reload'>搜索</button>" +
                "</div>");
        Map m = new HashMap();
        m.put("url","/supervise/csgl/listEqcsByX2");
        m.put("type","reload");
        String[] data = {"sbcsName"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));
    }
    //维修商
    @PostMapping("/listEqcsByX3")
    public Result listEqcsByX3(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               EqCsSelectVO selectVo){
        PageInfo date = eqCsService.listEqcsByX3(pageNum,pageSize,selectVo);
        return Result.success(date);
    }
    @PostMapping("eqcsTitles")
    public Result eqcsTitles() {
        String title ="[{'type': 'radio'}, "+
                "{field: 'sbcsName', title: '供货商'},"+
                "{field: 'sbcsLxr1', title: '联系人'},"+
                "{field: 'sbcsLxdh1', title: '联系电话'},"+
                "{field: 'email', title: 'Email地址'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }
}
