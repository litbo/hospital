package com.litbo.hospital.security.inspectionplan.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.inspectionplan.bean.InspEqPlanRecord;
import com.litbo.hospital.security.inspectionplan.bean.vo.RecordSelectVo.*;
import com.litbo.hospital.security.inspectionplan.bean.vo.SelectRecordVo;
import com.litbo.hospital.security.inspectionplan.bean.vo.UserVo1;
import com.litbo.hospital.security.inspectionplan.dao.InspEqPlRecordDao;
import com.litbo.hospital.security.inspectionplan.service.InspEqPlRecordService;
import com.litbo.hospital.security.specialequipment.utils.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 10366 2019-08-26 23:12
 **/
@Service
public class InspEqPlRecordServiceImpl implements InspEqPlRecordService {



    @Autowired
    private InspEqPlRecordDao
            inspEqPlRecordDao;


    public PageInfo<UserVo1> selectAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspEqPlRecordDao.selectAllUser());
    }
    public PageInfo<UserVo1> selectUserByUserVo(int pageNum, int pageSize,String userId, String userXm, String bmName) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspEqPlRecordDao.selectUserByUserVo(userId, userXm, bmName));
    }


    /**
     * 功能描述: 查询 往日此巡检计划的巡检记录
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 10:13
     */
    public PageInfo<PLanAndNowExecuteRecordVo> selectPLanAndNowExecuteRecordVoByCondition(int pageNum, int pageSize,
                                                                                   String inspPlId, String beginTime1,
                                                                                          String endTime1, String beginTime2,
                                                                                          String endTime2){
        PageHelper.startPage(pageNum, pageSize);
        Date end1 = null;
        Date begin1 = null;
        Date end2 = null;
        Date begin2 = null;
        try {
            end1 = new SimpleDateFormat("yyyy-MM-dd").parse(endTime1);
            begin1 = new SimpleDateFormat("yyyy-MM-dd").parse(beginTime1);
            end2 = new SimpleDateFormat("yyyy-MM-dd").parse(endTime2);
            begin2 = new SimpleDateFormat("yyyy-MM-dd").parse(beginTime2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<PLanAndNowExecuteRecordVo> pLanAndNowExecuteRecordVoList = inspEqPlRecordDao.selectPLanAndNowExecuteRecordVoByCondition(inspPlId, begin1, end1, begin2, end2);
        System.out.println(pLanAndNowExecuteRecordVoList);
        return new PageInfo<>(inspEqPlRecordDao.selectPLanAndNowExecuteRecordVoByCondition(inspPlId, begin1, end1, begin2, end2));
    }

    /**
     * 功能描述: 查询 往日此巡检计划的巡检记录
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/31 0031 10:13
     */
    public PageInfo<PLanAndNowExecuteRecordVo> selectPLanAndNowExecuteRecordVoById(int pageNum, int pageSize,
                                                                                   String inspPlId){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspEqPlRecordDao.selectPLanAndNowExecuteRecordVoById(inspPlId));
    }

    /**
     * 功能描述: 根据记录id查询巡检记录
     *
     * @Param: inspReId
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 10:22
     */
    public InspRecordLookVo selectRecordByRecordId(String inspReId){
        InspEqPlanRecord inspEqPlanRecord = inspEqPlRecordDao.selectInspRecordByRecordId(inspReId);
        InspRecordLookVo inspRecordLookVo = new InspRecordLookVo();

        EquipmentVo equipmentVo = inspEqPlRecordDao.selectEqById(inspEqPlanRecord.getEqSbbh());

        inspRecordLookVo.setEqSbbh(equipmentVo.getEqSbbh());
        inspRecordLookVo.setEqName(equipmentVo.getEqName());
        inspRecordLookVo.setBmName(equipmentVo.getBmName());
        inspRecordLookVo.setEqXh(equipmentVo.getEqXh());

        inspRecordLookVo.setInspPlBmQz(inspEqPlanRecord.getInspPlBmQz());
        inspRecordLookVo.setInspPlExecutor(inspEqPlRecordDao.selectUserNameById(inspEqPlanRecord.getInspPlExecutor()));
        inspRecordLookVo.setInspPlExecutorTime(inspEqPlanRecord.getInspPlExecutorTime());
        inspRecordLookVo.setInspPlPeople(inspEqPlanRecord.getInspPlPeople());

        ArrayList arrayList = new ArrayList();
        String inspPlStandardIds = inspEqPlanRecord.getInspPlStandardIds();
        inspRecordLookVo.setInspPlStandardResults(inspEqPlanRecord.getInspPlStandardResults());
        inspRecordLookVo.setInspPlOtherProblem(inspEqPlanRecord.getInspPlOtherProblem());

        JSONArray objects = JSON.parseArray(inspPlStandardIds);
        if(objects.size()!= 0){
            for (int j = 0; j < objects.size(); j++) {

                arrayList.add(inspEqPlRecordDao.selectStandardNameById(objects.getString(j)));

            }
        }
        String [] array = (String [])arrayList.toArray(new String[0]);
        inspRecordLookVo.setInspPlStandardNames(array);
////
////        ArrayList arrayList1 = new ArrayList();
////        JSONArray objects1 = JSON.parseArray(inspPlStandardResults);
////        if(objects1.size()!= 0){
////            for (int j = 0; j < objects1.size(); j++) {
////
////                arrayList1.add(objects1.getString(j));
////
////            }
////        }
////        String [] array1 = (String [])arrayList.toArray(new String[0]);
////        inspRecordLookVo.setInspPlStandardResults(array1);



        return inspRecordLookVo;
    }



    /**
     * 功能描述: 查看录入结果Vo
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 0:09
     */
    public PageInfo<SelectRecordVo> selectRecordVoByCondition(int pageNum, int pageSize,
                                                              String inspPlName, String eqName,
                                                              String bmName, String beginTime,
                                                              String endTime) {
        PageHelper.startPage(pageNum, pageSize);
        Date parse = null;
        Date parse1 = null;
        try {
            parse = new SimpleDateFormat("yyyy-MM-dd").parse(beginTime);
            parse1 = new SimpleDateFormat("yyyy-MM-dd").parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new PageInfo<>(inspEqPlRecordDao.selectRecordVoByCondition(inspPlName, eqName,
                bmName, parse, parse1));
    }

    /**
     * 功能描述: 查看录入结果
     *
     * @Param:
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/28 0028 0:09
     */
    public PageInfo<SelectRecordVo> selectRecordVo(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(inspEqPlRecordDao.selectRecordVo());
    }



    /**
     * 功能描述: 结果录入 查询巡检计划
     *
     * @Param: inspPlId
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 0:19
     */
    public InspSelectPlanVo selectInspPlById(String inspPlId){

        List<InspSelectVo> inspSelectVos = inspEqPlRecordDao.selectInspPlById(inspPlId);
        InspSelectPlanVo inspSelectPlanVo = new InspSelectPlanVo();
        InspSelectVo inspSelectVo = inspSelectVos.get(0);

        List<InspSelectPlanEqVo> inspSelectPlanEqVos = new ArrayList<>() ;


        //1.插入基本信息
        inspSelectPlanVo.setInspPlId(inspSelectVo.getInspPlId());
        inspSelectPlanVo.setInspPlName(inspSelectVo.getInspPlName());
        inspSelectPlanVo.setInspPlCreateTime(inspSelectVo.getInspPlCreateTime());

        for (InspSelectVo selectVo : inspSelectVos) {

            EquipmentVo equipmentVo = new EquipmentVo();
            InspSelectPlanEqVo inspSelectPlanEqVo = new InspSelectPlanEqVo();
            equipmentVo = inspEqPlRecordDao.selectEqById(selectVo.getInspPlEqSbbh());
            inspSelectPlanEqVo.setEqSbbh(equipmentVo.getEqSbbh());
            inspSelectPlanEqVo.setEqName(equipmentVo.getEqName());
            inspSelectPlanEqVo.setBmName(equipmentVo.getBmName());
            inspSelectPlanEqVo.setEqXh(equipmentVo.getEqXh());
            inspSelectPlanEqVo.setQzzp(inspEqPlRecordDao.selectQzzpBySbbh(equipmentVo.getEqSbbh()));


            List<InspSelectPlanEqStandardsVo> inspSelectPlanEqStandardsVos = new ArrayList<>();
            String inspPlEqStandards = selectVo.getInspPlEqStandards();
            JSONArray objects = JSON.parseArray(inspPlEqStandards);
            if(objects.size()!= 0){
                for (int j = 0; j < objects.size(); j++) {
                    inspSelectPlanEqStandardsVos.add(
                            inspEqPlRecordDao.selectStandardById(objects.getString(j))
                    );

                }
            }
            inspSelectPlanEqVo.setInspSelectPlanEqStandardsVos(inspSelectPlanEqStandardsVos);

            inspSelectPlanEqVos.add(inspSelectPlanEqVo);

        }

        inspSelectPlanVo.setInspSelectPlanEqVos(inspSelectPlanEqVos);

        return inspSelectPlanVo;

    }


    /**
     * 功能描述: 保存巡检计划
     *
     * @Param: InspEqPlanRecord
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 8:44
     */
//    @Transactional
//    public void insertInspRecord(InspEqPlRecordVo inspEqPlRecordVo,
//                                 String executor){
//
//        InspEqPlanRecord inspEqPlanRecord = new InspEqPlanRecord();
//
//        //插入基本的巡检记录
//        inspEqPlanRecord.setInspPlId(inspEqPlRecordVo.getInspPlId());
//        inspEqPlanRecord.setInspPlExecutor(executor);
//        inspEqPlanRecord.setInspPlExecutorTime(new Date());
//        inspEqPlanRecord.setInspPlPeople(inspEqPlRecordVo.getInspPlPeople());
//
//        List<InspEqPlRecordEqVo> inspEqPlRecordEqVos = inspEqPlRecordVo.getInspEqPlRecordEqVos();
//
//        for (InspEqPlRecordEqVo inspEqPlRecordEqVo : inspEqPlRecordEqVos) {
//
//
//            inspEqPlanRecord.setInspReId(
//                    GenerateId.getIdByIDAndTime("z_inspection_eq_plan_record", "insp_re_id")
//            );
//            inspEqPlanRecord.setEqSbbh(inspEqPlRecordEqVo.getEqSbbh());
//            inspEqPlanRecord.setInspPlBmQz(
//                    inspEqPlRecordDao.selectQzzpBySbbh(inspEqPlRecordEqVo.getEqSbbh())
//            );
//
//            inspEqPlanRecord.setInspPlStandardIds(
//                    JSON.toJSONString(inspEqPlRecordEqVo.getInspPlStandardIds())
//            );
//            inspEqPlanRecord.setInspPlStandardResults(
//                    JSON.toJSONString(inspEqPlRecordEqVo.getInspPlStandardResults())
//            );
//            inspEqPlanRecord.setInspPlOtherProblem(
//                    JSON.toJSONString(inspEqPlRecordEqVo.getInspPlOtherProblem())
//            );
//            if (inspEqPlRecordVo.getInspPlId()!=null){
//                inspEqPlRecordDao.deleteOtherInspPlan(inspEqPlRecordVo.getInspPlId());
//            }
//
//            inspEqPlRecordDao.updateLastInspTime(inspEqPlRecordVo.getInspPlId(), new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//
//
//
//            //日期判断 周|月
//            Calendar calendar = Calendar.getInstance();
//            Date date = new Date();
//            calendar.setTime(date);
//            int i = Integer.parseInt(inspEqPlRecordDao.selectPeriod(inspEqPlRecordVo.getInspPlId()));
//
//            if(inspEqPlRecordDao.selectPeriodUnit(inspEqPlRecordVo.getInspPlId()) == 0){
//
//                calendar.add(Calendar.WEEK_OF_MONTH,i);
//            }else {
//                i = i*inspEqPlRecordDao.selectPeriodUnit(inspEqPlRecordVo.getInspPlId());
//                calendar.add(Calendar.MONTH, i);
//            }
//            inspEqPlRecordDao.updatePlanTime(inspEqPlRecordVo.getInspPlId(),new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
//
//            inspEqPlRecordDao.insertInspPlRecord(inspEqPlanRecord);
//
//        }
//
//    }

    /**
     * 功能描述: 保存巡检计划
     *
     * @Param: InspEqPlanRecord
     * @Return:
     * @Author: ZYJ
     * @Date: 2019/8/27 0027 8:44
     */
    @Transactional
    public void insertInspRecord(InspEqPlRecordVo inspEqPlRecordVo,
                                 String executor){

        InspEqPlanRecord inspEqPlanRecord = new InspEqPlanRecord();

        //插入基本的巡检记录
        inspEqPlanRecord.setInspPlId(inspEqPlRecordVo.getInspPlId());
        inspEqPlanRecord.setInspPlExecutor(executor);
        //插入计划执行时间
        inspEqPlanRecord.setInspPlExecutorTime(inspEqPlRecordDao.selectPlanExecuteTimeById(inspEqPlRecordVo.getInspPlId() ));
        inspEqPlanRecord.setInspPlPeople(inspEqPlRecordVo.getInspPlPeople());
        //插入实际执行完时间
        inspEqPlanRecord.setSpare1(new Date());

        List<InspEqPlRecordEqVo> inspEqPlRecordEqVos = inspEqPlRecordVo.getInspEqPlRecordEqVos();

        for (InspEqPlRecordEqVo inspEqPlRecordEqVo : inspEqPlRecordEqVos) {


            inspEqPlanRecord.setInspReId(
                    GenerateId.getIdByIDAndTime("z_inspection_eq_plan_record", "insp_re_id")
            );
            inspEqPlanRecord.setEqSbbh(inspEqPlRecordEqVo.getEqSbbh());
            inspEqPlanRecord.setInspPlBmQz(
                    inspEqPlRecordEqVo.getQzzp()
            );

            inspEqPlanRecord.setInspPlStandardIds(
                    JSON.toJSONString(inspEqPlRecordEqVo.getInspPlStandardIds())
            );
            inspEqPlanRecord.setInspPlStandardResults(
                    JSON.toJSONString(inspEqPlRecordEqVo.getInspPlStandardResults())
            );
            inspEqPlanRecord.setInspPlOtherProblem(
                    JSON.toJSONString(inspEqPlRecordEqVo.getInspPlOtherProblem())
            );


            //如果是其他巡检，则停用
            if (inspEqPlRecordVo.getInspPlId()!=null){
                if ("0".equals( inspEqPlRecordDao.selectInspTypeById(inspEqPlRecordVo.getInspPlId() ))){
                    inspEqPlRecordDao.updateInspStatusById(inspEqPlRecordVo.getInspPlId() );
                }

            }

            //更改巡检计划的计划上次巡检日期
            inspEqPlRecordDao.updateLastInspTime(inspEqPlRecordVo.getInspPlId(), new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

            //日期判断 周|月
            Calendar calendar = Calendar.getInstance();
            Date date = new Date();
            calendar.setTime(date);
            int i = Integer.parseInt(inspEqPlRecordDao.selectPeriod(inspEqPlRecordVo.getInspPlId()));

            if(inspEqPlRecordDao.selectPeriodUnit(inspEqPlRecordVo.getInspPlId()) == 0){

                calendar.add(Calendar.WEEK_OF_MONTH,i);
            }else {
                i = i*inspEqPlRecordDao.selectPeriodUnit(inspEqPlRecordVo.getInspPlId());
                calendar.add(Calendar.MONTH, i);
            }
            //更新巡检计划的计划巡检日期
            inspEqPlRecordDao.updatePlanTime(inspEqPlRecordVo.getInspPlId(),new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));

            inspEqPlRecordDao.insertInspPlRecord(inspEqPlanRecord);

        }

    }





}
