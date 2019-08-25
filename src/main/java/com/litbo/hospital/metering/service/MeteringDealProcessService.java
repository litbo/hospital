package com.litbo.hospital.metering.service;

import com.litbo.hospital.metering.pojo.MeteringApprovalForm;
import com.litbo.hospital.metering.pojo.MeteringDealProcess;
import com.litbo.hospital.metering.pojo.MeteringHistoryNumber;
import com.litbo.hospital.metering.pojo.MeteringUtil;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/9 20:52
 * @Version:
 * @Description:
 */
public interface MeteringDealProcessService {

    // 添加报表，返回报表的id
    int addForm(MeteringApprovalForm meteringApprovalForm);

    // 查找报表
    List<MeteringApprovalForm> searchApprovalForm(String recordBeginTime, String recordEndTime,
                                                  String department, String status,
                                                  String dealBeginTime,String dealEndTime);

    // 根据流程中的id字符串查找所有的设备信息
    List<MeteringUtil> findUtilByProcess(String ids);

    // 根据流程找到这个流程中的报表
    MeteringApprovalForm findFormByFormID(int id);

    int updateFormByPrimaryKeySelective(MeteringApprovalForm record);



    // 添加流程
    int addProcess(MeteringDealProcess meteringDealProcess);

    // 查找已处理流程
    List<MeteringDealProcess> searchFormProcess(String recordBeginTime, String recordEndTime,
                                                  String department, String status,
                                                  String dealBeginTime,String dealEndTime);


    // 查找未处理流程
    List<MeteringDealProcess> searchFormProcessNot(String recordBeginTime, String recordEndTime,String department);

    MeteringDealProcess selectMeteringDealProcessByPrimaryKey(int id);

    int updateProcessByPrimaryKeySelective(MeteringDealProcess record);

    int deleterProcess(int processId);


    int verificationResultEntry(MeteringHistoryNumber number);
}
