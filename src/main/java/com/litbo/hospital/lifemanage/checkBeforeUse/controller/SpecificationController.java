package com.litbo.hospital.lifemanage.checkBeforeUse.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.checkBeforeUse.service.SpecificationService;
import com.litbo.hospital.lifemanage.checkBeforeUse.vo.*;
import com.litbo.hospital.result.Result;
import net.sf.cglib.core.Local;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lifeManage")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;


    /**
     * 查询所有设备
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
                "{field: 'bmName', title: '科室名称'},"+
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
                "{field: 'bmName', title: '科室名称'},"+
                "{field: 'bmId', title: '科室Id'},"+
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
                        "<button class='layui-btn' data-type='reload'>查询</button>" +
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


    @PostMapping("searchUnFinishedTaskEqs")
    public Result searchUnFinishedTaskEqs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                               String bmId){


        System.out.println(bmId);
        PageInfo<TaskEqVo> taskEqVoPageInfo = specificationService.searchTaskEqs(pageNum,pageSize,bmId,0);

        return Result.success(taskEqVoPageInfo);
    }


    @PostMapping("searchFinishedTaskEqs")
    public Result searchFinishedTaskEqs(@RequestParam(value = "pageNum" ,required = false,defaultValue="1") int pageNum,
                                @RequestParam(value = "pageSize",required = false,defaultValue="10") int pageSize,
                                String bmId){


        System.out.println(bmId);
        PageInfo<TaskEqVo> taskEqVoPageInfo = specificationService.searchTaskEqs(pageNum,pageSize,bmId,1);

        return Result.success(taskEqVoPageInfo);
    }

    @PostMapping("searchUnFinishedEqTask")
    public Result searchUnFinishedEqTask(String eqSbbh){
        System.out.println(eqSbbh);
        List<SearchStandardTaskVO> searchStandardTaskVOS = specificationService.searchUnFinishedEqTask(eqSbbh);
        return Result.success(searchStandardTaskVOS);
    }

    @PostMapping("searchFinishedEqTask")
    public Result searchFinishedEqTask(String eqSbbh){
        System.out.println(eqSbbh);
        List<SearchStandardTaskVO> searchStandardTaskVOS = specificationService.searchFinishedEqTask(eqSbbh);
        return Result.success(searchStandardTaskVOS);
    }

    @PostMapping("saveTaskResult")
    public Result saveTaskResult(@RequestBody ResultList list){

        list.getList().forEach(a->{
            System.out.println(a.getTaskId() + "----" + a.getOperatorNumber() +"----" + a.getUserXm()+ "----" + a.getTaskResult());
        });
        specificationService.saveTaskResult(list.getList());
        return Result.success();
    }


    /**
     * 查询当天科室的检查情况
     * @return 检查情况
     */
    @GetMapping("searchUseForBmEq")
    public Result searchUseForBmEq(){
        List<BmTaskEqVO> bmTaskEqVOS = specificationService.searchBmTaskEqsByDay();
        bmTaskEqVOS.forEach(System.out::println);
        return Result.success(bmTaskEqVOS);

    }

    /**
     * 查询部门分科室查询
     * @param startDate 开始时间 默认  上个月一号
     * @param endDate   结束时间 默认  上个月最后一天
     * @param bmId      科室id
     * @param bmName    科室名称
     * @return          查询结果
     */
    @GetMapping("searchUseForBmEqByDate")
    public Result searchUseForBmEqByDate(@RequestParam(value = "startDate",required = false)String startDate,
                                         @RequestParam(value = "endDate",required = false) String endDate,
                                         @RequestParam("bmId") String bmId,
                                         @RequestParam(value = "bmName") String bmName){
        LocalDate today = LocalDate.now().minusMonths(1);


        LocalDate s = null;
        LocalDate e = null;
        if (endDate == null){
            e = today.with(TemporalAdjusters.lastDayOfMonth());
        }else {
            e = LocalDate.parse(endDate);
        }
        if (startDate == null){
            s = LocalDate.of(today.getYear(),today.getMonth(),1);
        }else {
            s = LocalDate.parse(startDate);
        }

        List<BmTaskEqVO> bmTaskEqVOS = specificationService.searchUseForBmEqByDate(s,e,bmId,bmName);

        bmTaskEqVOS.forEach(System.out::println);

        return Result.success(bmTaskEqVOS);
    }
























}
