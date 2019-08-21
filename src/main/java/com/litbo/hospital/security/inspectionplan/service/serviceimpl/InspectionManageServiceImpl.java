package com.litbo.hospital.security.inspectionplan.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.inspectionplan.bean.InspEqPlan;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanEquipmentVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanProgramVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanSelectVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.InspPlanVo;
import com.litbo.hospital.security.inspectionplan.dao.InspPlDrawUpDao;
import com.litbo.hospital.security.inspectionplan.dao.InspectionManageDao;
import com.litbo.hospital.security.inspectionplan.service.InspectionManageService;
import com.litbo.hospital.security.specialequipment.utils.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private InspPlDrawUpDao
            inspPlDrawUpDao;


    /**
     * 功能描述:根据巡检计划Id查询巡检计划信息
     *
     * @Param: inspPlId
     * @Return: List<InspEqPlan>
     * @Author: ZYJ
     * @Date: 2019/8/14 0014 15:25
     */
    public InspPlanVo selectInspPlanById(String inspPlId){
        List<InspEqPlan> inspEqPlans = inspectionManageDao.selectInspPlanById(inspPlId);
        InspPlanVo inspPlanVo = new InspPlanVo();
        ArrayList<InspPlanProgramVo> inspPlanProgramVos = new ArrayList<InspPlanProgramVo>();
        ArrayList arrayList = new ArrayList<Integer>();

        InspEqPlan inspEqPlan = inspEqPlans.get(0);

        //第一步 封装计划基本信息
        inspPlanVo.setInspPlName(inspEqPlan.getInspPlName());
        inspPlanVo.setInspPlPlanner(inspEqPlan.getInspPlPlanner());
        inspPlanVo.setInspPlAuditor(inspEqPlan.getInspPlAuditor());
        inspPlanVo.setInspPlCreateTime(inspEqPlan.getInspPlCreateTime());
        inspPlanVo.setInspPlNote(inspEqPlan.getInspPlNote());
        inspPlanVo.setInspPlStatus(inspEqPlan.getInspPlStatus());

        //求出此计划有几个项目
        for (int i = 0; i < inspEqPlans.size(); i++) {
            String inspPlSprare1 = inspEqPlans.get(i).getInspPlSprare1();
            arrayList.add(Integer.parseInt(inspPlSprare1));
        }
        int[] d = new int[arrayList.size()];
        for(int i = 0;i<arrayList.size();i++){
            d[i] = (int)arrayList.get(i);
        }
        Arrays.sort(d);
        int a = d[d.length - 1];



        for (int i = 1; i < a+1; i++) {
            String s = String.valueOf(i);
            InspPlanProgramVo inspPlanProgramVo = new InspPlanProgramVo();

            for (InspEqPlan eqPlan : inspEqPlans) {
                if(eqPlan.getInspPlSprare1().equals(s)){
                    //封装program的基本信息
                    inspPlanProgramVo.setInspPlType(eqPlan.getInspPlType());
                    inspPlanProgramVo.setInspPlPeriodicUnit(eqPlan.getInspPlPeriodicUnit());
                    inspPlanProgramVo.setInspPlPeriod(eqPlan.getInspPlPeriod());
                    inspPlanProgramVo.setInspPlLastTime(eqPlan.getInspPlLastTime());
                    inspPlanProgramVo.setInspPlExecutorType(eqPlan.getInspPlExecutorType());
                    break;
                }
            }

            ArrayList<InspPlanEquipmentVo> inspPlanEquipmentVos = new ArrayList<>();

            for (InspEqPlan eqPlan : inspEqPlans) {

                //相当于把同一个项目的eqPlan取出来
                if(eqPlan.getInspPlSprare1().equals(s)){
                    ArrayList arrayList1 = new ArrayList<String>();
                    InspPlanEquipmentVo inspPlanEquipmentVo = new InspPlanEquipmentVo();
                    String inspPlEqStandards = eqPlan.getInspPlEqStandards();
                    JSONArray objects = JSON.parseArray(inspPlEqStandards);
                    if(objects.size()!= 0){
                        for (int j = 0; j < objects.size(); j++) {
                            arrayList1.add(objects.getString(j));
                        }
                    }

                    String [] array = (String [])arrayList1.toArray(new String[0]);

                    inspPlanEquipmentVo.setInspPlStandards(array);
                    inspPlanEquipmentVo.setEqSbbh(eqPlan.getInspPlEqSbbh());
                    //把同一个项目的设备信息添加进去
                    inspPlanEquipmentVos.add(inspPlanEquipmentVo);

                }
            }

            inspPlanProgramVo.setInspPlanEquipmentVos(inspPlanEquipmentVos);

            inspPlanProgramVos.add(inspPlanProgramVo);

        }
        //将programs添加到Vo中
        inspPlanVo.setInspPlanProgramVos(inspPlanProgramVos);



        return inspPlanVo;
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
        return new PageInfo<>(inspectionManageDao.selectAllInspPlanVo());
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
        return new PageInfo<>(inspectionManageDao.selectInspPlanVo(inspPlName, inspPlPlanner,
                inspPlAuditor, inspPlStatus));
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
    public synchronized int addInspPlan(InspPlanVo inspPlanVo) {

        InspEqPlan inspEqPlan = new InspEqPlan();
        ArrayList<InspPlanProgramVo> inspPlanProgramVos = inspPlanVo.getInspPlanProgramVos();

        String programs = "1";


        String inspPlId = GenerateId.getIdByIDAndTime("z_inspection_eq_plan", "insp_pl_id");

        //生成巡检计划Id插入
        inspEqPlan.setInspPlId(inspPlId);
        //插入巡检计划信息
        inspEqPlan.setInspPlName(inspPlanVo.getInspPlName());
        inspEqPlan.setInspPlPlanner(inspPlanVo.getInspPlPlanner());
        inspEqPlan.setInspPlCreateTime(inspPlanVo.getInspPlCreateTime());
        inspEqPlan.setInspPlAuditor(inspPlanVo.getInspPlAuditor());
        inspEqPlan.setInspPlNote(inspPlanVo.getInspPlNote());
        inspEqPlan.setInspPlStatus(inspPlanVo.getInspPlStatus());


        for (InspPlanProgramVo inspPlanProgramVo : inspPlanProgramVos) {
            //插入巡检项目基本信息
            inspEqPlan.setInspPlSprare1(programs);
            inspEqPlan.setInspPlExecutorType(inspPlanProgramVo.getInspPlExecutorType());
            inspEqPlan.setInspPlLastTime(inspPlanProgramVo.getInspPlLastTime());
            inspEqPlan.setInspPlPeriod(inspPlanProgramVo.getInspPlPeriod());
            inspEqPlan.setInspPlPeriodicUnit(inspPlanProgramVo.getInspPlPeriodicUnit());
            inspEqPlan.setInspPlType(inspPlanProgramVo.getInspPlType());

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

            ArrayList<InspPlanEquipmentVo> inspPlanEquipmentVos = inspPlanProgramVo.getInspPlanEquipmentVos();

            for (InspPlanEquipmentVo inspPlanEquipmentVo : inspPlanEquipmentVos) {
                String[] inspPlStandards = inspPlanEquipmentVo.getInspPlStandards();
                String inspPlStandard = JSON.toJSONString(inspPlStandards);

                //插入对应的 设备编号和对应的设备标准数组
                inspEqPlan.setInspPlEqSbbh(inspPlanEquipmentVo.getEqSbbh());
                inspEqPlan.setInspPlEqStandards(inspPlStandard);

                //封装完毕，插入表中
                inspectionManageDao.insertInspPlan(inspEqPlan);
            }

            int add = Integer.parseInt(programs);
            add+=1;
            programs = String.valueOf(add);
        }

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
