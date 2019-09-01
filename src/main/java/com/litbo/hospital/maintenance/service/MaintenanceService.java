package com.litbo.hospital.maintenance.service;

import com.litbo.hospital.maintenance.pojo.Consumables;
import com.litbo.hospital.maintenance.pojo.Maintenance;
import com.litbo.hospital.maintenance.pojo.MaintenanceProject;
import com.litbo.hospital.maintenance.vo.AddEqVo;
import com.litbo.hospital.maintenance.vo.EqInfoVo;
import com.litbo.hospital.maintenance.vo.MaintenancePlanVo;
import com.litbo.hospital.user.bean.EqInfo;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/28 3:01
 * @Version:
 * @Description:
 */
public interface MaintenanceService {

    // 规范编制   -----》  展示需要制定规范的设备
    List<EqInfoVo> getEQMessage(String riskLevel,String bmName,String eqName);

    // 添加规范
    int addMaintenance(Maintenance maintenance,String eqName,Boolean ifNotRisk);

    // 添加设备风险值
    int addMaintenance(Maintenance maintenance);

    // 添加规范中的项目
    int addMaintenanceProject(MaintenanceProject maintenanceProject);

    //按条件查找设备
    List<AddEqVo> selectEqBy(String factory,String model,String bmName,String similarClass,String pym);

    List<String> seeAllType(String type);

    List findAllKey(String type,String value);

    Maintenance selectByEqId(String id);

    EqInfo selectEqById(String id);

    List<MaintenancePlanVo> seeAllMaintenancePlan(String planName, String beginTime, String endTime, String status);

    // 查看计划内容
    List<MaintenanceProject> seePlanContent(int id);

    // 将计划变为任务
    int planToTask(int id);

    int deletePlan(int id);

    // 添加设备易耗品
    int addConsumables(Consumables consumables);


    // 维护保养结果录入
    int resultAdd(int maintenanceId,String maintenanceResults,String instrumentStatus,String description,
                  String maintenancePersonnel,String checkTime,String departmentReceipt,String dateOfCompletion);

    int deleteType(String name);


}
