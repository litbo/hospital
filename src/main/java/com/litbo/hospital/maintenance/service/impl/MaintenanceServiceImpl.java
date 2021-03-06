package com.litbo.hospital.maintenance.service.impl;

import com.litbo.hospital.maintenance.dao.ConsumablesDAO;
import com.litbo.hospital.maintenance.dao.ImplementerDictionaryDAO;
import com.litbo.hospital.maintenance.dao.MaintenanceDAO;
import com.litbo.hospital.maintenance.dao.MaintenanceProjectDAO;
import com.litbo.hospital.maintenance.pojo.Consumables;
import com.litbo.hospital.maintenance.pojo.ImplementerDictionary;
import com.litbo.hospital.maintenance.pojo.Maintenance;
import com.litbo.hospital.maintenance.pojo.MaintenanceProject;
import com.litbo.hospital.maintenance.service.MaintenanceService;
import com.litbo.hospital.maintenance.vo.AddEqVo;
import com.litbo.hospital.maintenance.vo.EqInfoVo;
import com.litbo.hospital.maintenance.vo.MaintenanceMessageVo;
import com.litbo.hospital.maintenance.vo.MaintenancePlanVo;
import com.litbo.hospital.user.bean.EqInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/28 3:02
 * @Version:
 * @Description:
 */
@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private ConsumablesDAO consumablesDAO;

    @Autowired
    private MaintenanceDAO maintenanceDAO;

    @Autowired
    private MaintenanceProjectDAO maintenanceProjectDAO;

    @Autowired
    private ImplementerDictionaryDAO implementerDictionaryDAO;

    @Override
    public List<EqInfoVo> getEQMessage(String riskLevel, String bmName, String eqName) {
        if(bmName != null){
            bmName = "%" + bmName + "%";
        }

        if(eqName != null){
            eqName = "%" + eqName + "%";
        }

        return maintenanceDAO.getEQMessage(riskLevel, bmName, eqName);
    }

    @Override
    public int addMaintenance(Maintenance maintenance,String eqName,Boolean ifNotRisk) {
        Maintenance maintenanceMessage = maintenanceDAO.selectByEqId(maintenance.getEqId());
        // 该设备还没有风险值，所以要返回
        if(maintenanceMessage == null){
            return 0;
        }

        // 查看该设备是否已经编制规范，如果已经有了规范，就不能重复添加
        if(maintenanceMessage.getName() != null){
            if(maintenanceMessage.getProjectList() != null){
                return 0;
            }
        }
        maintenance.setId(maintenanceMessage.getId()); // id
        maintenance.setName(eqName+"预防性维护计划");   // 计划名称
        maintenance.setEqId(maintenanceMessage.getEqId());   // 设备id
        maintenance.setRiskValue(maintenanceMessage.getRiskValue()); // 风险值
        maintenance.setRiskLevel(maintenanceMessage.getRiskLevel()); // 风险等级
        maintenance.setPlanType("预防性维护计划");  // 计划类型
        if(maintenance.getCycleRule().equals("按风险值估算")){   // 周期
            switch (maintenance.getRiskLevel()){
                case "高":
                    maintenance.setCycle("6");
                    break;
                case "中":
                    maintenance.setCycle("12");
                    break;
            }
        }

        maintenance.setStatus("试用中");

        return maintenanceDAO.updateByPremaryKey(maintenance);
    }

    @Override
    public int addMaintenance(Maintenance maintenance) {
        Maintenance maintenance1 = maintenanceDAO.selectByEqId(maintenance.getEqId());
        if(maintenance1 != null){
            maintenance1.setRiskValue(maintenance.getRiskValue());
            maintenance1.setRiskLevel(maintenance.getRiskLevel());
            return maintenanceDAO.updateByPremaryKey(maintenance1);
        }
        return maintenanceDAO.insert(maintenance);
    }

    @Override
    public int addMaintenanceProject(MaintenanceProject maintenanceProject) {
        int result = 0;

        // 添加项目
        result = maintenanceProjectDAO.insert(maintenanceProject);
        if(result == 1){
            return maintenanceProjectDAO.getLastId();
        }
        return 0;
    }

    @Override
    public int updateMaintenanceProject(MaintenanceProject maintenanceProject) {
        return maintenanceProjectDAO.updateProject(maintenanceProject);
    }

    @Override
    public MaintenanceProject selectProjectById(int id) {
        return maintenanceProjectDAO.selectById(id);
    }

    @Override
    public int deleteMaintenanceProject(int id) {
        return maintenanceProjectDAO.deleteProject(id);
    }

    @Override
    public List<AddEqVo> selectEqBy(String factory, String model, String bmName, String similarClass, String pym) {
        return maintenanceDAO.selectEq(factory, model, bmName, similarClass, pym);
    }


    @Override
    public List<String> seeAllType(String type) {
        return implementerDictionaryDAO.findAllType(type);
    }

    @Override
    public List findAllKey(String type,String value) {
        if(type != null){
            type = "%" + type +"%";
        }
        if(value != null){
            value = "%" + value +"%";
        }
        return implementerDictionaryDAO.selectAll(type,value);
    }

    @Override
    public Maintenance selectByEqId(String id) {
        return maintenanceDAO.selectByEqId(id);
    }

    @Override
    public EqInfo selectEqById(String id) {
        return maintenanceDAO.selectEqById(id);
    }

    @Override
    public List<MaintenancePlanVo> seeAllMaintenancePlan(String planName, String beginTime, String endTime, String status) {
        if(planName != null){
            planName = "%" + planName + "%";
        }
        return maintenanceDAO.seeAllMaintenancePlan(planName, beginTime, endTime, status);
    }

    @Override
    public List<MaintenanceProject> seePlanContent(int id) {
        Maintenance maintenance = maintenanceDAO.selectById(id);
        if(maintenance == null){
            return new ArrayList<>();
        }
        String[] projects = maintenance.getProjectList().split(",");
        List<MaintenanceProject> list = new ArrayList<>();
        for(String i : projects){
            MaintenanceProject project = maintenanceProjectDAO.selectById(Integer.parseInt(i));
            if(project == null){
                continue;
            }
            list.add(project);
        }
        return list;
    }

    @Override
    public Maintenance seePlan(int id) {
        return maintenanceDAO.selectById(id);
    }

    @Override
    public int planToTask(int id) {
        Maintenance maintenance = maintenanceDAO.selectById(id);
        maintenance.setStatus("待执行");
        return maintenanceDAO.updateByPremaryKey(maintenance);
    }

    @Override
    public int deletePlan(int id) {
        return maintenanceDAO.deletePlan(id);
    }

    @Override
    public int addConsumables(Consumables consumables) {
        return consumablesDAO.insert(consumables);
    }

    @Override
    public List<Consumables> getConsumables(int id) {
        return consumablesDAO.getConsumables(id);
    }

    @Override
    public int resultAdd(int maintenanceId, String maintenanceResults, String instrumentStatus, String description,
                         String maintenancePersonnel, String checkTime, String departmentReceipt, String dateOfCompletion) {
        Maintenance maintenance = maintenanceDAO.selectById(maintenanceId);
        maintenance.setStatus("已完成");
        maintenance.setMaintenanceResults(maintenanceResults);  // 保养结果
        maintenance.setInstrumentStatus(instrumentStatus);  // 仪器现状
        maintenance.setDescription(description); //备注
        maintenance.setMaintenancePersonnel(maintenancePersonnel);  // 维护人
        maintenance.setDepartmentReceipt(departmentReceipt); // 科室签收

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(System.currentTimeMillis());
        maintenance.setDateOfCompletion(time); // 完成日期
        return maintenanceDAO.updateByPremaryKey(maintenance);
    }

    @Override
    public int projectResultAdd(int maintenanceId, String maintenanceResults, String maintenancePersonnel) {
        MaintenanceProject project = maintenanceProjectDAO.selectById(maintenanceId);
        if(project == null){
            return 0;
        }
        project.setResult(maintenanceResults);  // 结果
        project.setFirstTime(new SimpleDateFormat( "yyyy-MM-dd").format(new Date())); // 首次执行时间
        project.setStandard(maintenancePersonnel);  // 维护人
        return maintenanceProjectDAO.updateProject(project);
    }

    @Override
    public int deleteType(String name) {
        return implementerDictionaryDAO.deleteByName(name);
    }

    @Override
    public int addKeyAndValue(String key, String Value) {
        ImplementerDictionary i = new ImplementerDictionary();
        i.setType(key);
        i.setValue(Value);
        return implementerDictionaryDAO.insert(i);
    }

    @Override
    public MaintenanceMessageVo getMessgeVo(String id) {
        return maintenanceDAO.getMessgeVo(id);
    }


}
