package com.litbo.hospital.security.inspectionplan.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.inspectionplan.bean.InspEqPlan;
import com.litbo.hospital.security.inspectionplan.bean.vo.*;
import com.litbo.hospital.security.inspectionplan.bean.vo.SelectVo.InspPlanEquipmentVo1;
import com.litbo.hospital.security.inspectionplan.bean.vo.SelectVo.InspPlanProgramVo1;
import com.litbo.hospital.security.inspectionplan.bean.vo.SelectVo.InspPlanVo1;
import com.litbo.hospital.security.inspectionplan.dao.InspPlDrawUpDao;
import com.litbo.hospital.security.inspectionplan.dao.InspectionManageDao;
import com.litbo.hospital.security.inspectionplan.service.InspectionManageService;
import com.litbo.hospital.security.specialequipment.utils.GenerateId;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 巡检计划管理 【 增、删、改、查】ServiceImpl
 *
 * @author 10366 2019-08-09 10:45
 *
 **/

@Service
public class InspectionManageServiceImpl implements InspectionManageService {


    @Autowired
    private InspectionManageDao
            inspectionManageDao;



    /**
     * 功能描述: 查询变更记录是否存在
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/20 0020 12:43
     */
    public void selectRecordIsNot(InspPlanVo inspPlanVo, String changePerson) {
        String s = inspectionManageDao.selectRecordIsNot(inspPlanVo.getInspPlanId());
        if(StringUtils.isNullOrEmpty(s)){
            String inspPlChangeId = GenerateId.getIdByIDAndTime("z_inspection_eq_plan_change", "insp_pl_change_id");
            inspectionManageDao.insertChangeRecord1(inspPlChangeId, inspPlanVo.getInspPlanId(),
                    changePerson, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), inspPlanVo.getInspPlChangeReason());
        }else {
            inspectionManageDao.updateChangeRecord1(inspectionManageDao.selectRecordChangeId(inspPlanVo.getInspPlanId()), inspPlanVo.getInspPlanId(),
                    changePerson, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), inspPlanVo.getInspPlChangeReason());
        }

    }
    /**
     * 功能描述: 更改巡检计划信息
     *
     * @Param: InspPlanVo11
     * @Return: void
     * @Author: ZYJ
     * @Date: 2019/8/18 0018 18:44
     */
    @Transactional
    public int updateInspPlan(InspPlanVo inspPlanVo, String userId){

//        selectRecordIsNot(inspPlanVo, userId);

        //取出对应计划的Id
        String inspPlanId = inspPlanVo.getInspPlanId();
        String planner = inspectionManageDao.selectInspPlPlanner(inspPlanId);
        String spare3 = inspectionManageDao.selectInspPlSpare3(inspPlanId);


        //1.删除原有的数据 但是保存他的主键值
        inspectionManageDao.deleteInspPlByPlId(inspPlanId);


        //2.将原来的主键插入进去 并且将新的数据插入
        InspEqPlan inspEqPlan = new InspEqPlan();


        //生成巡检计划Id插入
        inspEqPlan.setInspPlId(inspPlanId);
        //插入巡检计划信息
        inspEqPlan.setInspPlChangeReason(inspPlanVo.getInspPlChangeReason());
        inspEqPlan.setInspPlName(inspPlanVo.getInspPlName());
        inspEqPlan.setInspPlPlanner(planner);
        inspEqPlan.setInspPlSprare3(spare3);
        inspEqPlan.setInspPlCreateTime(inspPlanVo.getInspPlCreateTime());
        inspEqPlan.setInspPlAuditor(inspPlanVo.getInspPlAuditor());
        inspEqPlan.setInspPlSprare4(inspPlanVo.getInspPlSpare4());
        inspEqPlan.setInspPlNote(inspPlanVo.getInspPlNote());
        inspEqPlan.setInspPlStatus(inspPlanVo.getInspPlStatus());


        inspEqPlan.setInspPlLastTime(inspPlanVo.getInspPlLastTime());
        inspEqPlan.setInspPlPeriod(inspPlanVo.getInspPlPeriod());
        inspEqPlan.setInspPlPeriodicUnit(inspPlanVo.getInspPlPeriodicUnit());

        inspEqPlan.setInspPlExecutorType(inspPlanVo.getInspPlExecutorType());
        inspEqPlan.setInspPlType(inspPlanVo.getInspPlType());
        //日期判断 周|月
        Calendar calendar = Calendar.getInstance();
        Date date = inspEqPlan.getInspPlLastTime();
        calendar.setTime(date);
        int i = Integer.parseInt(inspEqPlan.getInspPlPeriod());

        if(inspEqPlan.getInspPlPeriodicUnit() == 0){

            calendar.add(Calendar.WEEK_OF_MONTH,i);
        }else {
            i = i*inspEqPlan.getInspPlPeriodicUnit();
            calendar.add(Calendar.MONTH, i);
        }
        inspEqPlan.setInspPlPlanExecuteTime(calendar.getTime());
        ArrayList<InspPlanEquipmentVo> inspPlanEquipmentVos = inspPlanVo.getInspPlanEquipmentVos();
        for (InspPlanEquipmentVo inspPlanEquipmentVo : inspPlanEquipmentVos) {
            String[] inspPlStandards = inspPlanEquipmentVo.getInspPlStandards();
            String inspPlStandard = JSON.toJSONString(inspPlStandards);

            //插入对应的 设备编号和对应的设备标准数组
            inspEqPlan.setInspPlEqSbbh(inspPlanEquipmentVo.getEqSbbh());
            inspEqPlan.setInspPlEqStandards(inspPlStandard);

            //封装完毕，插入表中
            inspectionManageDao.insertInspPlan(inspEqPlan);
        }



        //清除所有选定项
        inspectionManageDao.updateSelectionToZero();

        return 1;

    }

    /**
     * 功能描述: 变更设备选定情况
     *
     * @Param: ArrayList<InspEqPlan>
     * @Return: void
     * @Author: ZYJ
     * @Date: 2019/8/21 0021 0:15
     */
    public void changeEqSelection(List<InspEqPlan> inspEqPlans){
        for (InspEqPlan inspEqPlan : inspEqPlans) {
            inspectionManageDao.updateEqSelectionBySbbh(inspEqPlan.getInspPlEqSbbh());
        }
    }
    /**
     * 功能描述:根据巡检计划Id查询巡检计划信息
     *
     * @Param: inspPlId
     * @Return: List<InspEqPlan>
     * @Author: ZYJ
     * @Date: 2019/8/14 0014 15:25
     */
    public InspPlanVo1 selectInspPlanById(String inspPlId){
        List<InspEqPlan> inspEqPlans = inspectionManageDao.selectInspPlanById(inspPlId);
        changeEqSelection(inspEqPlans);
        InspPlanVo1 inspPlanVo1 = new InspPlanVo1();

        InspEqPlan inspEqPlan = inspEqPlans.get(0);

        //第一步 封装计划基本信息
        inspPlanVo1.setInspPlanId(inspEqPlan.getInspPlId());
        inspPlanVo1.setInspPlName(inspEqPlan.getInspPlName());
        inspPlanVo1.setInspPlPlanner(inspEqPlan.getInspPlPlanner()+"+"+
                inspectionManageDao.selectUserNameById(inspEqPlan.getInspPlPlanner()));
        inspPlanVo1.setInspPlAuditor(inspEqPlan.getInspPlAuditor()+"+"+
                inspectionManageDao.selectUserNameById(inspEqPlan.getInspPlAuditor()));
        inspPlanVo1.setInspPlCreateTime(inspEqPlan.getInspPlCreateTime());
        inspPlanVo1.setInspPlNote(inspEqPlan.getInspPlNote());
        inspPlanVo1.setInspPlStatus(inspEqPlan.getInspPlStatus());
        inspPlanVo1.setInspPlChangeReason(inspEqPlan.getInspPlChangeReason());

        inspPlanVo1.setInspPlPeriodicUnit(inspEqPlan.getInspPlPeriodicUnit());
        inspPlanVo1.setInspPlPeriod(inspEqPlan.getInspPlPeriod());
        inspPlanVo1.setInspPlLastTime(inspEqPlan.getInspPlLastTime());
        inspPlanVo1.setInspPlExecutorType(inspEqPlan.getInspPlExecutorType());
        inspPlanVo1.setInspPlType(inspEqPlan.getInspPlType());

        ArrayList<InspPlanEquipmentVo1> inspPlanEquipmentVos = new ArrayList<>();
        for (InspEqPlan eqPlan : inspEqPlans) {
            ArrayList arrayList1 = new ArrayList<String>();
            InspPlanEquipmentVo1 inspPlanEquipmentVo1 = new InspPlanEquipmentVo1();
            String inspPlEqStandards = eqPlan.getInspPlEqStandards();
            JSONArray objects = JSON.parseArray(inspPlEqStandards);
            if(objects.size()!= 0) {
                for (int j = 0; j < objects.size(); j++) {

                    arrayList1.add(objects.getString(j));

                    arrayList1.add(inspectionManageDao.selectStandardNameById(
                            objects.getString(j)
                    ));
                    arrayList1.add(inspectionManageDao.selectStandardDescriptionById(
                            objects.getString(j)
                    ));
                }

                String [] array = (String [])arrayList1.toArray(new String[0]);
                InspEquipmentVo inspEquipmentVo = inspectionManageDao.selectEqVoById(eqPlan.getInspPlEqSbbh());
                inspPlanEquipmentVo1.setEqName(inspEquipmentVo.getEqName());
                inspPlanEquipmentVo1.setEqXh(inspEquipmentVo.getEqXh());
                inspPlanEquipmentVo1.setBmName(inspEquipmentVo.getBmName());
                inspPlanEquipmentVo1.setInspPlStandards(array);
                inspPlanEquipmentVo1.setEqSbbh(eqPlan.getInspPlEqSbbh());


                inspPlanEquipmentVos.add(inspPlanEquipmentVo1);

            }
        }

        inspPlanVo1.setInspPlanEquipmentVo1s(inspPlanEquipmentVos);


        return inspPlanVo1;
    }


    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    public PageInfo<InspPlanSelectVo> selectAllInspPlanVo(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<InspPlanSelectVo> inspPlanSelectVos = inspectionManageDao.selectAllInspPlanVo();
        for (InspPlanSelectVo inspPlanSelectVo : inspPlanSelectVos) {
            inspPlanSelectVo.setInspPlAuditor(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlAuditor()));
            inspPlanSelectVo.setInspPlPlanner(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlPlanner()));

        }
        return new PageInfo<>(inspPlanSelectVos);
    }
    public PageInfo<InspPlanSelectVo1> selectAllResultInspPlanVo(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<InspPlanSelectVo1> inspPlanSelectVos = inspectionManageDao.selectAllResultInspPlanVo();
        for (InspPlanSelectVo1 inspPlanSelectVo : inspPlanSelectVos) {
            inspPlanSelectVo.setInspPlAuditor(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlAuditor()));
            inspPlanSelectVo.setInspPlPlanner(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlPlanner()));

        }
        return new PageInfo<>(inspPlanSelectVos);
    }

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    public PageInfo<InspPlanSelectVo> selectInspPlanVo(int pageNum, int pageSize,
                                                       String inspPlName, String inspPlPlanner,
                                                       String inspPlAuditor, String inspPlStatus){

        PageHelper.startPage(pageNum, pageSize);
        List<InspPlanSelectVo> inspPlanSelectVos = inspectionManageDao.selectInspPlanVo(inspPlName, inspPlPlanner,
                inspPlAuditor, inspPlStatus);
        for (InspPlanSelectVo inspPlanSelectVo : inspPlanSelectVos) {
            inspPlanSelectVo.setInspPlAuditor(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlAuditor()));
            inspPlanSelectVo.setInspPlPlanner(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlPlanner()));

        }
        return new PageInfo<>(inspPlanSelectVos);
    }
    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    public PageInfo<InspPlanSelectVo1> selectResultInspPlanVo(int pageNum, int pageSize,
                                                       String inspPlName, String inspPlPlanner,
                                                       String inspPlAuditor, String inspPlStatus){

        PageHelper.startPage(pageNum, pageSize);
        List<InspPlanSelectVo1> inspPlanSelectVos = inspectionManageDao.selectResultInspPlanVo(inspPlName, inspPlPlanner,
                inspPlAuditor, inspPlStatus);
        for (InspPlanSelectVo1 inspPlanSelectVo : inspPlanSelectVos) {
            inspPlanSelectVo.setInspPlAuditor(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlAuditor()));
            inspPlanSelectVo.setInspPlPlanner(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlPlanner()));

        }
        return new PageInfo<>(inspPlanSelectVos);
    }



    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    public PageInfo<InspPlanSelectVo> selectAllApproveInspPlanVo(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<InspPlanSelectVo> inspPlanSelectVos = inspectionManageDao.selectAllApproveInspPlanVo();
        for (InspPlanSelectVo inspPlanSelectVo : inspPlanSelectVos) {
            inspPlanSelectVo.setInspPlAuditor(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlAuditor()));
            inspPlanSelectVo.setInspPlPlanner(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlPlanner()));

        }
        return new PageInfo<>(inspPlanSelectVos);
    }

    /**
     * 功能描述: 查询巡检计划列表
     *
     * @Param: inspPlName inspPlPlanner inspPlAuditor inspPlStatus
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/13 0013 16:03
     */
    public PageInfo<InspPlanSelectVo> selectApproveInspPlanVo(int pageNum, int pageSize,
                                                       String inspPlName, String inspPlPlanner,
                                                       String inspPlAuditor, String inspPlStatus){

        PageHelper.startPage(pageNum, pageSize);
        List<InspPlanSelectVo> inspPlanSelectVos = inspectionManageDao.selectApproveInspPlanVo(inspPlName, inspPlPlanner,
                inspPlAuditor, inspPlStatus);
        for (InspPlanSelectVo inspPlanSelectVo : inspPlanSelectVos) {
            inspPlanSelectVo.setInspPlAuditor(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlAuditor()));
            inspPlanSelectVo.setInspPlPlanner(inspectionManageDao.selectUserNameById(inspPlanSelectVo.getInspPlPlanner()));

        }
        return new PageInfo<>(inspPlanSelectVos);
    }

    /**
     * 功能描述: 添加巡检计划
     *
     * @Param: inspPlanVo
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/12 0012 19:16
     */
    @Transactional
    public synchronized int addInspPlan(InspPlanVo inspPlanVo, String planner, String inspPlSpare3) {

        InspEqPlan inspEqPlan = new InspEqPlan();

        String programs = "1";


        String inspPlId = GenerateId.getIdByIDAndTime("z_inspection_eq_plan", "insp_pl_id");

        //生成巡检计划Id插入
        inspEqPlan.setInspPlId(inspPlId);
        //插入巡检计划信息
        inspEqPlan.setInspPlName(inspPlanVo.getInspPlName());
        inspEqPlan.setInspPlPlanner(planner);
        inspEqPlan.setInspPlSprare3(inspPlSpare3);
        inspEqPlan.setInspPlCreateTime(inspPlanVo.getInspPlCreateTime());
        inspEqPlan.setInspPlAuditor(inspPlanVo.getInspPlAuditor());
        inspEqPlan.setInspPlSprare4(inspPlanVo.getInspPlSpare4());
        inspEqPlan.setInspPlNote(inspPlanVo.getInspPlNote());
        inspEqPlan.setInspPlStatus(inspPlanVo.getInspPlStatus());

        inspEqPlan.setInspPlLastTime(inspPlanVo.getInspPlLastTime());
        inspEqPlan.setInspPlPeriod(inspPlanVo.getInspPlPeriod());
        inspEqPlan.setInspPlPeriodicUnit(inspPlanVo.getInspPlPeriodicUnit());
        inspEqPlan.setInspPlExecutorType(inspPlanVo.getInspPlExecutorType());
        inspEqPlan.setInspPlType(inspPlanVo.getInspPlType());
        //日期判断 周|月
        Calendar calendar = Calendar.getInstance();
        Date date = inspEqPlan.getInspPlLastTime();
        calendar.setTime(date);
        int i = Integer.parseInt(inspEqPlan.getInspPlPeriod());

        if(inspEqPlan.getInspPlPeriodicUnit() == 0){

            calendar.add(Calendar.WEEK_OF_MONTH,i);
        }else {
            i = i*inspEqPlan.getInspPlPeriodicUnit();
            calendar.add(Calendar.MONTH, i);
        }
        inspEqPlan.setInspPlPlanExecuteTime(calendar.getTime());



        ArrayList<InspPlanEquipmentVo> inspPlanEquipmentVos = inspPlanVo.getInspPlanEquipmentVos();

        for (InspPlanEquipmentVo inspPlanEquipmentVo : inspPlanEquipmentVos) {
            String[] inspPlStandards = inspPlanEquipmentVo.getInspPlStandards();
            String inspPlStandard = JSON.toJSONString(inspPlStandards);

            //插入对应的 设备编号和对应的设备标准数组
            inspEqPlan.setInspPlEqSbbh(inspPlanEquipmentVo.getEqSbbh());
            inspEqPlan.setInspPlEqStandards(inspPlStandard);

            //封装完毕，插入表中
            inspectionManageDao.insertInspPlan(inspEqPlan);
        }




        inspectionManageDao.updateSelectionToZero();

        return 1;
    }

    /**
     * 功能描述: 根据巡检计划id删除巡检计划
     *
     * @Param: inspPlId
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 13:35
     */
    public int deleteInspPlByPlId(String inspPlId){
        return inspectionManageDao.deleteInspPlByPlId(inspPlId);
    }

    /**
     * 功能描述: 根据巡检计划id 巡检计划中的其它巡检
     *
     * @Param: inspPlId
     * @Return: int
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 13:35
     */
    public int deleteInspPlByPlType(String inspPlId){
        return inspectionManageDao.deleteInspPlByType(inspPlId);
    }

    /**
     * 功能描述: 同意审批
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    public int approvedForInspection(String[] inspPlIds){
        for (String inspPlId : inspPlIds) {
            inspectionManageDao.approvedForInspection(inspPlId);
        }
        return  1;
    }

    /**
     * 功能描述: 拒绝审批
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    public int rejectedForInspection(String[] inspPlIds){
        for (String inspPlId : inspPlIds) {
            inspectionManageDao.rejectedFroInspection(inspPlId);
        }
        return  1;
    }

    /**
     * 功能描述: 变更提交后 status => 4
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/9 0009 15:23
     */
    public void updatePlus(String inspPlId){
        inspectionManageDao.updatePlus(inspPlId);
    }





}
