package com.litbo.hospital.metering.service.impl;

import com.litbo.hospital.metering.dao.MeteringApprovalFormDAO;
import com.litbo.hospital.metering.dao.MeteringDealProcessDAO;
import com.litbo.hospital.metering.dao.MeteringHistoryNumberDAO;
import com.litbo.hospital.metering.dao.MeteringUtilDAO;
import com.litbo.hospital.metering.pojo.MeteringApprovalForm;
import com.litbo.hospital.metering.pojo.MeteringDealProcess;
import com.litbo.hospital.metering.pojo.MeteringHistoryNumber;
import com.litbo.hospital.metering.pojo.MeteringUtil;
import com.litbo.hospital.metering.service.MeteringDealProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/9 20:52
 * @Version:
 * @Description:
 */
@Service
public class MeteringDealProcessServiceImpl implements MeteringDealProcessService {

    @Autowired
    private MeteringDealProcessDAO meteringDealProcessDAO;

    @Autowired
    private MeteringApprovalFormDAO meteringApprovalFormDAO;

    @Autowired
    private MeteringUtilDAO meteringUtilDAO;

    @Autowired
    private MeteringHistoryNumberDAO meteringHistoryNumberDAO;

    @Override
    public int addForm(MeteringApprovalForm meteringApprovalForm) {
        // 为表单设置生成时间
        String birthTime = new SimpleDateFormat("yyyy/MM/dd HH:MM:ss a").format(new Date());
        meteringApprovalForm.setRecordTime(birthTime);

        // 生成表单名，保证表单名唯一
        String time = birthTime.split(" ")[0];
        String description = time + System.currentTimeMillis();
        meteringApprovalForm.setDescription(description);
        int result = meteringApprovalFormDAO.insert(meteringApprovalForm);
        if(result == 0){
            return 0;
        }
        return meteringApprovalFormDAO.selectByFormDescription(description).getFormId();
    }

    @Override
    public List<MeteringApprovalForm> searchApprovalForm(String recordBeginTime, String recordEndTime,
                                                         String department, String status,
                                                         String dealBeginTime,String dealEndTime) {
        return meteringApprovalFormDAO.searchApprovalForm(recordBeginTime, recordEndTime, department, status, dealBeginTime, dealEndTime);
    }

    @Override
    public List<MeteringUtil> findUtilByProcess(String ids) {
        String[] allId = ids.split(",");
        List<MeteringUtil> utils = new ArrayList<>();

        for(int i = 0 ; i < allId.length ; i++){
            System.out.println(allId[i]);
        }

        for(int i = 0 ; i < allId.length ; i++){
            try {
                Integer id = Integer.valueOf(allId[i]);
                MeteringUtil util = meteringUtilDAO.selectByPrimaryKey(id);
                if(util != null){
                    utils.add(util);
                }
            }catch (Exception e){
                System.out.println("流程中的id字符串无法转化为一个个的id...");
                return null;
            }
        }
        return utils;
    }

    @Override
    public MeteringApprovalForm findFormByFormID(int id) {
        return meteringApprovalFormDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateFormByPrimaryKeySelective(MeteringApprovalForm record) {
        return meteringApprovalFormDAO.updateByPrimaryKey(record);
    }

    @Override
    public int addProcess(MeteringDealProcess meteringDealProcess) {
        return meteringDealProcessDAO.insert(meteringDealProcess);
    }

    @Override
    public List<MeteringDealProcess> searchFormProcess(String recordBeginTime, String recordEndTime, String department, String status, String dealBeginTime, String dealEndTime) {


        if(status != null){
            if(status.equals("")){
            return meteringDealProcessDAO.searchDealProcess(recordBeginTime, recordEndTime, department, null, dealBeginTime, dealEndTime);
        }
            status = "%"+status+"%";
        }

        return meteringDealProcessDAO.searchDealProcess(recordBeginTime, recordEndTime, department, status, dealBeginTime, dealEndTime);
    }

    @Override
    public List<MeteringDealProcess> searchFormProcessNot(String recordBeginTime, String recordEndTime, String department) {
        return meteringDealProcessDAO.searchDealProcessNot(recordBeginTime, recordEndTime, department);
    }

    @Override
    public MeteringDealProcess selectMeteringDealProcessByPrimaryKey(int id) {
        return meteringDealProcessDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateProcessByPrimaryKeySelective(MeteringDealProcess record) {
        return meteringDealProcessDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleterProcess(int processId) {
        return meteringDealProcessDAO.deleteByPrimaryKey(processId);
    }

    @Override
    public int verificationResultEntry(MeteringHistoryNumber number) {
        // 查出设备
        MeteringUtil util = meteringUtilDAO.selectByPrimaryKey(number.getMeteringutilId());

        // 计算出下次送去计量的时间
        // 使用Calendar类来计算下一次的计量时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(number.getGetNumberTime()));
        calendar.add(Calendar.MONTH,Integer.parseInt(util.getMeteringInspectionCycle()));
        //得到下一次的计量时间
        Date nextMeteringTime = calendar.getTime();
        util.setThisMeteringTime(new SimpleDateFormat("yyyy/MM/dd").format(nextMeteringTime));

        // 有效日期
        util.setEffectiveDate(util.getThisMeteringTime());

        if(number.getVerificationNumber() != null){
            number.setVerificationResult("合格");
        }else{
            number.setVerificationResult("不合格");
        }
        number.setMeteringutillNumber(util.getMeteringSystemNum());
        number.setRecordTime(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        number.setEffectiveDate(util.getEffectiveDate());

        // 更新设备信息
        util.setDescription("0");// 从流程中拿出去
        util.setThisMeteringTime(number.getEffectiveDate());  // 下次审计时间
        util.setMeteringGetNumberTime(number.getGetNumberTime());


        int i = meteringUtilDAO.updateByPrimaryKey(util);
        if(i != 0){
            i = meteringHistoryNumberDAO.insert(number);
        }

        return i;
    }

    @Override
    public List<MeteringUtil> seeAllUtilsMeteringUtil(String bmName,String utilName) {
        // 查出来所有已经审批通过，等待结果录入的流程中包含的设备信息
        List<String> utilIds = meteringDealProcessDAO.seeAllUtilsMeteringUtil();
        List<MeteringUtil> utils = new ArrayList<>();

        if(bmName != null && utilName != null){
            for(String ids : utilIds){
                String[] id = ids.split(",");
                for(String i : id){
                    MeteringUtil util = meteringUtilDAO.selectByPrimaryKey(Integer.valueOf(i));
                    if(util.getBmName().equals(bmName) && util.getMeteringName().equals(utilName))
                    utils.add(util);
                }
            }
        }

        if(bmName == null && utilName != null){
            for(String ids : utilIds){
                String[] id = ids.split(",");
                for(String i : id){
                    MeteringUtil util = meteringUtilDAO.selectByPrimaryKey(Integer.valueOf(i));
                    if(util.getMeteringName().equals(utilName))
                        utils.add(util);
                }
            }
        }

        if(bmName != null && utilName == null){
            for(String ids : utilIds){
                String[] id = ids.split(",");
                for(String i : id){
                    MeteringUtil util = meteringUtilDAO.selectByPrimaryKey(Integer.valueOf(i));
                    if(util.getBmName().equals(bmName))
                        utils.add(util);
                }
            }
        }

        if(bmName == null && utilName == null){
            for(String ids : utilIds){
                String[] id = ids.split(",");
                for(String i : id){
                    MeteringUtil util = meteringUtilDAO.selectByPrimaryKey(Integer.valueOf(i));
                        utils.add(util);
                }
            }
        }


        return utils;
    }



}
