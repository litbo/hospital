package com.litbo.hospital.maintenance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.maintenance.pojo.Consumables;
import com.litbo.hospital.maintenance.pojo.Maintenance;
import com.litbo.hospital.maintenance.pojo.MaintenanceProject;
import com.litbo.hospital.maintenance.service.MaintenanceService;
import com.litbo.hospital.maintenance.vo.AddEqVo;
import com.litbo.hospital.maintenance.vo.EqInfoVo;
import com.litbo.hospital.maintenance.vo.MaintenancePlanVo;
import com.litbo.hospital.metering.vo.PageVo;
import com.litbo.hospital.result.Result;
import com.litbo.hospital.user.bean.EqInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/28 3:03
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;


    /**
     * 查看需要编制保养规范的设备
     * @param riskLevel 风险等级
     * @param bmName 部门名称
     * @param eqName 设备名
     * @param pageIndex 页码
     * @param pageSize 每页数据量
     * @return
     */
    @RequestMapping("/getEQMessage.do")
    public PageVo getEQMessage(@RequestParam(name = "riskLevel",defaultValue = "") String riskLevel,
                               @RequestParam(name = "bmName",defaultValue = "")String bmName ,
                               @RequestParam(name = "eqName",defaultValue = "")String eqName,
                               @RequestParam(name = "pageIndex" , defaultValue = "1")int pageIndex,
                               @RequestParam(name = "pageSize" , defaultValue = "15")int pageSize){

        if(riskLevel.equals("")){
            riskLevel = null;
        }

        if(eqName.equals("")){
            eqName = null;
        }

        if(bmName.equals(""))
        {
            bmName = null;
        }
        PageVo vo = new PageVo();
        PageHelper.startPage(pageIndex,pageSize);
        List<EqInfoVo> eqInfoList = maintenanceService.getEQMessage(riskLevel, bmName, eqName);

        PageInfo info = new PageInfo(eqInfoList);
        if(!eqInfoList.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),eqInfoList));
            return vo;
        }
        vo.setMsg("没有查询到设备信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),eqInfoList));
        return vo;
    }


    /**
     * 查看所有的实施人类型
     * @return
     */
    @RequestMapping("/seeAllType.do")
    public Result seeAllType(){
        List types = maintenanceService.seeAllType();
        if(types.isEmpty()){
            return Result.success("未查询到数据");
        }
        return Result.success(types);
    }


    /**
     * 添加设备风险值
     * @param eqId 设备id
     * @param riskValue 风险值
     * @return
     */
    @RequestMapping("/addRiskValue.do")
    public Result addRiskValue(String eqId,String riskValue){
        Maintenance maintenance = new Maintenance();
        maintenance.setEqId(eqId);
        maintenance.setRiskValue(riskValue);

        int value = Integer.parseInt(riskValue);
        if(value <= 8){
            maintenance.setRiskLevel("低");
        }else if(value >= 13){
            maintenance.setRiskLevel("高");
        }else{
            maintenance.setRiskLevel("中");
        }
        int result = maintenanceService.addMaintenance(maintenance);
        if(result == 0){
            return Result.success("添加失败");
        }
        return Result.success();
    }


    /**
     * 添加项目
     * @param maintenanceProject
     * @return
     */
    @RequestMapping("/addMaintenanceProject.do")
    public Result addMaintenanceProject(MaintenanceProject maintenanceProject){
        int result = maintenanceService.addMaintenanceProject(maintenanceProject);
        if(result == 0){
            return Result.success("添加失败");
        }
        return Result.success(result);
    }



    /**
     * 添加规范
     * @param maintenance 规范信息
     * @param applicable_eq 适用设备
     * @return
     */
    @RequestMapping("/addMaintenance.do")
    public Result addMaintenance(Maintenance maintenance,String applicable_eq){

        // 得到此设备的信息
        EqInfo eqInfo = maintenanceService.selectEqById(maintenance.getEqId());
        List <AddEqVo> list = new ArrayList<>();
        List <AddEqVo> addErrorList = new ArrayList<>();

        switch (applicable_eq){
            case "1":{  // 同厂家同类型
                list = maintenanceService.selectEqBy(eqInfo.getSbcsIdScs(),eqInfo.getEqXh(),null,null,null);
            }break;
            case "2":{  // 同类设备

            }break;
            case "3":{ // 按照简称
                list = maintenanceService.selectEqBy(null,null,null,null,eqInfo.getEqPym());
            }break;
            case "4":{ // 同科室
                list = maintenanceService.selectEqBy(null,null,eqInfo.getEqBmid(),null,null);
            }break;
            case "5":{  // 全部
                list = maintenanceService.selectEqBy(null,null,null,null,null);
            }break;
        }

        int result = 0 ;

        // 添加数据
        for(AddEqVo vo : list){
            maintenance.setEqId(vo.getId());
            result = maintenanceService.addMaintenance(maintenance,vo.getName());
            if(result == 0){
                addErrorList.add(vo);
            }
        }

        if(addErrorList.isEmpty()){
            return Result.success();
        }else{
//            return Result.success("有一部分数据未添加成功");
            return Result.success(addErrorList);
        }
    }


    /**
     * 查看预防性维护保养计划
     * @param pageIndex 页码
     * @param pageSize 每页数据量
     * @param planName 计划名称
     * @param beginTime 生成时间
     * @param endTime 生成时间
     * @param status 状态
     * @return
     */
    @RequestMapping("/seeAllMaintenancePlan.do")
    public PageVo seeAllMaintenancePlan(@RequestParam(name = "pageIndex" , defaultValue = "1")int pageIndex,
                             @RequestParam(name = "pageSize" , defaultValue = "15")int pageSize,
                             @RequestParam(name = "planName" , defaultValue = "")String planName,
                             @RequestParam(name = "beginTime" ,defaultValue = "")String beginTime,
                             @RequestParam(name = "endTime" ,defaultValue = "")String endTime,
                             @RequestParam(name = "status" , defaultValue = "")String status){
        if(planName.equals("")){
            planName = null;
        }

        if(beginTime.equals("")){
            beginTime = null;
        }

        if(endTime.equals("")){
            endTime = null;
        }

        if(status.equals("")){
            status = null;
        }
        PageVo vo = new PageVo();
        PageHelper.startPage(pageIndex,pageSize);
        List<MaintenancePlanVo> maintenancePlanVos = maintenanceService.seeAllMaintenancePlan(planName, beginTime, endTime, status);

        PageInfo info = new PageInfo(maintenancePlanVos);
        if(!maintenancePlanVos.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),maintenancePlanVos));
            return vo;
        }
        vo.setMsg("没有查询到信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),maintenancePlanVos));
        return vo;
    }


    /**
     * 查看计划内容
     * @param id 计划id
     * @return
     */
    @RequestMapping("/seePlanContent.do")
    public Result seePlanContent(int id){
        List<MaintenanceProject> list = maintenanceService.seePlanContent(id);
        if(list.isEmpty()){
            return Result.success("未查询到数据");
        }
        return Result.success(list);
    }

    /**
     * 将计划变成任务
     * @param id
     * @return
     */
    @RequestMapping("/planToTask.do")
    public Result planToTask(int id){
        int result = maintenanceService.planToTask(id);
        if(result == 0){
            return Result.success("任务添加失败");
        }
        return Result.success();
    }


    /**
     * 维护保养任务结果录入
     * @param maintenanceId  维护保养计划id
     * @param maintenanceResults 维护结果
     * @param instrumentStatus 仪器现状
     * @param description 备注
     * @param maintenancePersonnel 维护人员
     * @param checkTime 检查日期
     * @param departmentReceipt 部门签收
     * @param dateOfCompletion 完成日期
     * @return
     */
    @RequestMapping("/resultAdd.do")
    public Result resultAdd(int maintenanceId,String maintenanceResults,String instrumentStatus,String description,
                            String maintenancePersonnel,String checkTime,String departmentReceipt,String dateOfCompletion){

        int result = maintenanceService.resultAdd(maintenanceId, maintenanceResults, instrumentStatus, description, maintenancePersonnel, checkTime, departmentReceipt, dateOfCompletion);
        if(result == 0){
            return Result.success("插入失败");
        }
        return Result.success();
    }


    /**
     * 添加设备中的易耗品
     * @param consumables
     * @return
     */
    @RequestMapping("/addConsumables.do")
    public  Result addConsumables(Consumables consumables){
        int result = maintenanceService.addConsumables(consumables);
        if(result == 0){
            return Result.success("插入失败");
        }
        return Result.success();
    }



    //                                                   字典管理      begin
    @RequestMapping("/deleteType.do")
    public Result deleteType(String name){
        int result = maintenanceService.deleteType(name);
        if(result == 0){
            return Result.success("删除失败");
        }
        return Result.success();

    }
    //                                                   字典管理      end



}