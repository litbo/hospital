package com.litbo.hospital.maintenance.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.maintenance.pojo.Consumables;
import com.litbo.hospital.maintenance.pojo.Maintenance;
import com.litbo.hospital.maintenance.pojo.MaintenanceProject;
import com.litbo.hospital.maintenance.service.MaintenanceService;
import com.litbo.hospital.maintenance.util.PDFUtil;
import com.litbo.hospital.maintenance.vo.*;
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
     * @param bmName 科室名称
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
     * 查看所有的项目名称
     * @return
     */
    @RequestMapping("/seeAllType.do")
    public Result seeAllType(String type){
        List types = maintenanceService.seeAllType(type);
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
        MaintenanceProject m = maintenanceService.selectProjectById(result);
        if(result == 0){
            return Result.success("添加失败");
        }
        return Result.success(m);
    }

    /**
     * 删除项目
     * @param id
     * @return
     */
    @RequestMapping("/deleteMaintenanceProject.do")
    public Result deleteMaintenanceProject(int id){
        int result = maintenanceService.deleteMaintenanceProject(id);
        if(result == 0){
            return Result.success("添加失败");
        }
        return Result.success(result);
    }

    /**
     * 修改项目
     * @param maintenanceProject
     * @return
     */
    @RequestMapping("/updateMaintenanceProject.do")
    public Result updateMaintenanceProject(MaintenanceProject maintenanceProject){
        int result = maintenanceService.updateMaintenanceProject(maintenanceProject);
        if(result == 0){
            return Result.success("添加失败");
        }
        return Result.success(result);
    }


    /**
     * 添加项规范的时候添加项目信息
     * @param maintenance 规范信息
     * @param applicable_eq 使用设备
     * @param ifNotRisk 是否使用默认值
     * @param maintenanceProject 项目信息
     * @return
     */
    @RequestMapping("/addMaintenanceAndProject.do")
    public Result addMaintenanceAndProject(Maintenance maintenance,String applicable_eq,Boolean ifNotRisk,MaintenanceProject ... maintenanceProject){

        StringBuffer lists = new StringBuffer();

        for(MaintenanceProject m : maintenanceProject){
            int id = maintenanceService.addMaintenanceProject(m);
            lists.append(id).append(',');
        }

        maintenance.setProjectList(lists.toString());
        return addMaintenance(maintenance, applicable_eq, ifNotRisk);
    }



    /**
     * 添加规范
     * @param maintenance 规范信息
     * @param applicable_eq 适用设备
     * @param ifNotRisk 没有风险值的时候是否设置默认值
     * @return
     */
    @RequestMapping("/addMaintenance.do")
    public Result addMaintenance(Maintenance maintenance,String applicable_eq,Boolean ifNotRisk){

        // 添加保养内容的周期    begin
        String projects = maintenance.getProjectList();
        String[] project = projects.split(",");
        for(String i : project){
            try {
                MaintenanceProject mp = maintenanceService.selectProjectById(Integer.parseInt(i));
                mp.setCycle(maintenance.getCycle());
                maintenanceService.updateMaintenanceProject(mp);
            }catch (Exception e){
                System.out.println("预防性维护保养添加规范时无法解析保养内容");
            }

        }
        // 添加保养内容的周期    end


        // 得到此设备的信息
        EqInfo eqInfo = maintenanceService.selectEqById(maintenance.getEqId());
        List <AddEqVo> list = new ArrayList<>();
        List <AddEqVo> addErrorList = new ArrayList<>();

        switch (applicable_eq){
            case "1":{  // 同厂家同型号
                list = maintenanceService.selectEqBy(eqInfo.getSbcsIdScs(),eqInfo.getEqXh(),null,null,null);
            }break;
            case "2":{  // 同类设备
                list = maintenanceService.selectEqBy(null,null,null,eqInfo.getEqCxflId(),null);
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
            // 查看数据库中是否已经存在他的风险值
            Maintenance maintenance1 = maintenanceService.selectByEqId(vo.getId());
            if(maintenance1 == null){
                if(ifNotRisk == true){
                    addRiskValue(vo.getId(),maintenanceService.selectByEqId(maintenance.getEqId()).getRiskValue());
                }
            }
            maintenance.setEqId(vo.getId());
            result = maintenanceService.addMaintenance(maintenance,vo.getName(),ifNotRisk);
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
        Maintenance m = maintenanceService.seePlan(id);
        List<MaintenanceProject> list = maintenanceService.seePlanContent(id);

        PlanContentVo vo = new PlanContentVo(m,list);

        if(list.isEmpty()){
            return Result.success("未查询到数据");
        }
        return Result.success(vo);
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
     * 删除维护保养计划
     * @param planId 计划id
     * @return
     */
    @RequestMapping("/deletePlan.do")
    public Result deletePlan(int planId){
        int result = maintenanceService.deletePlan(planId);
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
     * @return
     */
    @RequestMapping("/resultAdd.do")
    public Result resultAdd(int maintenanceId,String maintenanceResults,String instrumentStatus,String description,
                            String maintenancePersonnel){

        int result = maintenanceService.resultAdd(maintenanceId, maintenanceResults, instrumentStatus, description, maintenancePersonnel, null,null,null);
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
    @RequestMapping("/deleteValue.do")
    public Result deleteValue(String value){
        int result = maintenanceService.deleteType(value);
        if(result == 0){
            return Result.success("删除失败");
        }
        return Result.success();

    }


    /**
     * 查看所有字典
     * @param pageIndex  页码
     * @param pageSize 每页数据量
     * @param type 项目类型
     * @param value 项目名称
     * @return
     */
    @RequestMapping("/findAllKey.do")
    public PageVo findAllKey(@RequestParam(name = "pageIndex" , defaultValue = "1")int pageIndex,
                             @RequestParam(name = "pageSize" , defaultValue = "15")int pageSize,
                             @RequestParam(name = "type",defaultValue = "") String type,
                             @RequestParam(name = "value",defaultValue = "") String value){
        if(type.equals("")){
            type = null;
        }

        if(value.equals("")){
            value = null;
        }
        PageVo vo = new PageVo();
        PageHelper.startPage(pageIndex,pageSize);
        List allKey = maintenanceService.findAllKey(type,value);

        PageInfo info = new PageInfo(allKey);
        if(!allKey.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),allKey));
            return vo;
        }
        vo.setMsg("没有查询到信息");
        vo.setCode(0);
        vo.setData(vo.new DataEntity((int) info.getTotal(),allKey));
        return vo;
    }
    //                                                   字典管理      end


    /**
     * 将维护结果生成PDF文件并保存到卷宗中
     * @param id 维护计划id
     * @return
     */
    @RequestMapping("/createDossierFile")
    public Result createDossierFile(int id){

//                                            维护项目信息        begin

        Maintenance maintenance = maintenanceService.seePlan(id);

        // 拿到维护计划的项目
        List<MaintenanceProject> projectList = maintenanceService.seePlanContent(id);

        List<List<MaintenanceProject>> ProjectLists= new ArrayList<>();

        if(!projectList.isEmpty()){
            List<MaintenanceProject> projectList1 = new ArrayList<>();
            List<MaintenanceProject> projectList2 = new ArrayList<>();
            List<MaintenanceProject> projectList3 = new ArrayList<>();
            List<MaintenanceProject> projectList4 = new ArrayList<>();
            List<MaintenanceProject> projectList5 = new ArrayList<>();
            List<MaintenanceProject> projectList6 = new ArrayList<>();


            for(MaintenanceProject project : projectList){
                switch (project.getProjectType()){
                    case "外观检查":{
                        projectList1.add(project);
                    }break;
                    case "清洁保养":{
                        projectList2.add(project);
                    }break;
                    case "更换维修":{
                        projectList3.add(project);
                    }break;
                    case "功能检查":{
                        projectList4.add(project);
                    }break;
                    case "性能检测校正":{
                        projectList5.add(project);
                    }break;
                    case "安全检查":{
                        projectList6.add(project);
                    }break;
                    default:{

                    }
                }
            }



            if(!projectList1.isEmpty()){
                ProjectLists.add(projectList1);
            }

            if(!projectList2.isEmpty()){
                ProjectLists.add(projectList2);
            }

            if(!projectList3.isEmpty()){
                ProjectLists.add(projectList3);
            }

            if(!projectList4.isEmpty()){
                ProjectLists.add(projectList4);
            }

            if(!projectList5.isEmpty()){
                ProjectLists.add(projectList5);
            }

            if(!projectList6.isEmpty()){
                ProjectLists.add(projectList6);
            }
        }

//                                            维护项目信息        end


//                                            设备信息        begin
        MaintenanceMessageVo maintenanceMessage = new MaintenanceMessageVo();

        maintenanceMessage.setBaoYangShiJian("1");
        maintenanceMessage.setBeiZhu("1");
        maintenanceMessage.setChanDi("1");
        maintenanceMessage.setDanJia("1");
        maintenanceMessage.setEqCatagory("灭菌类");
        maintenanceMessage.setFenLeiBianMa("1");
        maintenanceMessage.setGuiGeXingHao("1");
        maintenanceMessage.setJianChaRiQi("1");
        maintenanceMessage.setKeShiQianShou("1");
        maintenanceMessage.setQiYongShiJian("1");
        maintenanceMessage.setSheBeiMingCheng("1");
        maintenanceMessage.setShengChanChangJia("1");
        maintenanceMessage.setShiYongKeShi("1");
        maintenanceMessage.setWanChengRiQi("1");
        maintenanceMessage.setWeiBaoRen("1");
        maintenanceMessage.setWeiBaoZeRenRen("set");
        maintenanceMessage.setWeiHuRenYuan("sdfs");
        maintenanceMessage.setXuLieHao("sdfsdf");
        maintenanceMessage.setYiQiXianZhuang("sdfsdf");


//                                            设备信息        end


//        易耗品  begin
        List<Consumables> consumables = maintenanceService.getConsumables(id);
//        易耗品  end

        System.out.println("maintenanceMessage:\n"+maintenanceMessage+"\nProjectLists:\n"+ProjectLists+"\nconsumables\n"+consumables);


//        生成文件
        PDFUtil.createPDF(maintenanceMessage,ProjectLists,consumables);


        return Result.success();

    }



}
