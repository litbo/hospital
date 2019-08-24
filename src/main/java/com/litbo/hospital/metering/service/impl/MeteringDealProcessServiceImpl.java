package com.litbo.hospital.metering.service.impl;

import com.litbo.hospital.metering.dao.MeteringApprovalFormDAO;
import com.litbo.hospital.metering.dao.MeteringDealProcessDAO;
import com.litbo.hospital.metering.dao.MeteringUtilDAO;
import com.litbo.hospital.metering.pojo.MeteringApprovalForm;
import com.litbo.hospital.metering.pojo.MeteringDealProcess;
import com.litbo.hospital.metering.pojo.MeteringUtil;
import com.litbo.hospital.metering.service.MeteringDealProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
}
