package com.litbo.hospital.lifemanage.checkBeforeUse.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.checkBeforeUse.service.SpecificationService;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.*;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lifeManage")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;


    /**
     * 查找所有设备
     * @return 所有设备信息
     */
    @PostMapping("getEqInfos")
    public Result getEqInfos(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        return Result.success(specificationService.searchEqInfos(pageNum,pageSize));
    }


    @PostMapping("eqInfosTitle")
    public Result eqInfosTitle(){
        String title ="[{'type': 'radio'}, "+
                "{field: 'bmName', title: '部门名称'},"+
                "{field: 'eqId', title: '设备id'},"+
                "{field: 'eqName', title: '设备名称'},"+
                "{field: 'eqSbbh', title: '设备编号'},"+
                "{field: 'eqZcbh', title: '资产编号'},"+
                "{field: 'eqGg', title: '设备规格'},"+
                "{field: 'eqXh', title: '设备型号'},"+
                "{field: 'eqQysj', title: '启用时间'},"+
                "{field: 'eqPp', title: '品牌'}"+
                "]";
        return Result.success(JSON.parseArray(title));
    }


    @PostMapping("usersTitle")
    public Result usersTitle(){
        String title ="[{'type': 'radio'}, "+
                "{field: 'userId', title: '用户Id'},"+
                "{field: 'userXm', title: '用户姓名'},"+
                "{field: 'bmName', title: '部门名称'},"+
                "{field: 'bmId', title: '部门Id'},"+
                "]";
        return Result.success(JSON.parseArray(title));
    }



    @GetMapping("getUsers")
    public Result getUsers(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        return Result.success(specificationService.searchUsers(pageNum,pageSize));
    }


    @PostMapping("getAppointUsers")
    public Result geAppointUsers(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                 String name){
        return Result.success(specificationService.searchAppointUsers(pageNum,pageSize,name));
    }

    @GetMapping("getAppointUsers2")
    public Result geAppointUsers2(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                 @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                 String name){
        return Result.success(specificationService.searchAppointUsers(pageNum,pageSize,name));
    }

    @PostMapping("/userSe")
    public Result bmSe(){
        Map map =new HashMap();
        map.put("dom",
                "<div class='layui-inline'><input type=\"text\" name=\"name\" class=\"layui-input\" placeholder=\"用户姓名\" autocomplete=\"off\"></div>" +
                        "    <div class='layui-input-inline mar10-0' align='center'>" +
                        "<button class='layui-btn' data-type='reload'>搜索</button>" +
                        "</div>");

        Map m = new HashMap();
        m.put("url","/lifeManage/getAppointUsers2");
        m.put("type","reload");
        String[] data = {"name"};
        m.put("data",data);
        map.put("data",m);
        return Result.success(new JSONObject(map));

    }


    @PostMapping("getAppointEqInfos")
    public Result getAppointEqInfos(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                    @RequestParam(required = false,value = "eqSbbh") String sbbh,
                                    @RequestParam(required = false,value = "eqName") String eqName,
                                    @RequestParam(required = false,value = "eqPym") String eqPym,
                                    @RequestParam(required = false,value = "bmName") String bmName){

        return Result.success(specificationService.searchAppointEqInfos(pageNum,pageSize,sbbh,eqName,eqPym,bmName));
    }


    @PostMapping("saveStandard")
    public Result saveStandard(@RequestBody SaveStandardVO saveStandardVO){


        System.out.println(saveStandardVO);


        System.out.println(saveStandardVO);

        Integer standardId = specificationService.saveStandard(saveStandardVO);


        List<SaveStandardProjectVO> list = saveStandardVO.getList();


        if (!list.isEmpty()) {
            Integer s = specificationService.saveStandardProject(standardId, list);
        }

        return Result.success("success");
    }


    @PostMapping("searchAllStandards")
    public Result searchAllStandards(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                     @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                     @RequestParam(required = false,value = "result") Integer result){
        PageInfo<SearchStandardVO> pageInfo = specificationService.searchAllStandards(pageNum,pageSize,result);
        return Result.success(pageInfo);
    }

    @GetMapping("searchAllStandards2")
    public Result searchAllStandards2(@RequestParam(required = false,value = "result") Integer result){
        List<SearchStandardVO> pageInfo = specificationService.searchAllStandards2(result);
        return Result.success(pageInfo);
    }


    @PostMapping("getStandard")
    public Result searchStandard(Integer standardId){
        System.out.println(standardId);
        SearchStandardVO standardVO = specificationService.searchStandard(standardId);
        System.out.println(standardVO);
        return Result.success(standardVO);
    }


    @PostMapping("saveStandardResult")
    public Result saveStandardResult(Integer standardId, Integer result){
        System.out.println(standardId);
        System.out.println(result);
        String r = specificationService.updateStandardResult(standardId,result);
        return Result.success(r);
    }


    @DeleteMapping("deleteTaskBufferByStandardId")
    public Result deleteTaskBufferByStandardId(Integer standardId){
        System.out.println(standardId);
        String r = specificationService.deleteTaskBufferByStandardId(standardId);
        return Result.success(r);
    }


    @PostMapping("searchUnfinishedStandardTask")
    public Result searchUnfinishedStandardTask(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        PageInfo<SearchStandardTaskVO> searchStandardTaskVOPageInfo = specificationService.searchTodayUnfinishedStandardTask(pageNum,pageSize);
        return Result.success(searchStandardTaskVOPageInfo);
    }

    @PostMapping("searchFinishedStandardTask")
    public Result searchFinishedStandardTask(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize){
        System.out.println(2);
        PageInfo<SearchStandardTaskVO> searchStandardTaskVOPageInfo = specificationService.searchTodayFinishedStandardTask(pageNum,pageSize);
        return Result.success(searchStandardTaskVOPageInfo);
    }


    @PostMapping("saveStandardTaskResult")
    public Result saveStandardTaskResult(@RequestBody SaveStandardTaskResult saveStandardTaskResult){
        System.out.println(saveStandardTaskResult);
        String operatorNumber = saveStandardTaskResult.getOperatorNumber();
        Integer taskId = saveStandardTaskResult.getTaskId();
        Integer taskResult = saveStandardTaskResult.getTaskResult();
        String r = specificationService.searchStandardTaskResult(taskId,taskResult,operatorNumber);
        return Result.success(r);
    }

    @PostMapping("searchAppointUnfinishedStandardTasks")
    public Result searchAppointUnfinishedStandardTasks(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                         @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                         @RequestParam(value = "standardId",required = false) Integer standardId,
                                         @RequestParam(value = "bmId",required = false) String bmId,
                                         @RequestParam(value = "eqName",required = false) String eqName,
                                         @RequestParam(value = "eqSbbh",required = false) String eqSbbh){
        PageInfo<SearchStandardTaskVO> p = specificationService.searchAppointStandardTasks(pageNum,pageSize,
                                                                                standardId,bmId,eqName,eqSbbh,
                                                                                null);
        return Result.success(p);
    }

    @PostMapping("searchAppointFinishedStandardTasks")
    public Result searchAppointFinishedStandardTasks(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                             @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                             @RequestParam(value = "standardId",required = false) Integer standardId,
                                             @RequestParam(value = "bmId",required = false) String bmId,
                                             @RequestParam(value = "eqName",required = false) String eqName,
                                             @RequestParam(value = "eqSbbh",required = false) String eqSbbh){
        PageInfo<SearchStandardTaskVO> p = specificationService.searchAppointFinishedStandardTasks(pageNum,pageSize,
                standardId,bmId,eqName,eqSbbh,
                1);
        return Result.success(p);
    }
























}
