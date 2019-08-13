package com.litbo.hospital.metering.controller;

import com.litbo.hospital.metering.pojo.MeteringApprovalForm;
import com.litbo.hospital.metering.pojo.MeteringDealProcess;
import com.litbo.hospital.metering.pojo.MeteringUtil;
import com.litbo.hospital.metering.service.MeteringDealProcessService;
import com.litbo.hospital.metering.service.MeteringService;
import com.litbo.hospital.metering.vo.MeteringApprovalFormMoreInfomationVo;
import com.litbo.hospital.metering.vo.MeteringProcessMoreInformationVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/9 20:53
 * @Version:
 * @Description:
 */
@RestController
@ResponseBody
@RequestMapping("/meteringProcess")
public class MeteringDealProcessController {

    @Autowired
    private MeteringService meteringService;

    @Autowired
    private MeteringDealProcessService meteringDealProcessService;

    /**
     * 生成一个需要提交的计量报表，并将这个报表送进审批流程
     * @param department 处理报表的部门
     * @param utilIds 报表中计量设备的id，是个字符串，其中使用','隔开
     * @return
     */
    @RequestMapping("/addSomeMeteringUtilToProcess.do")
    public Result addSomeMeteringUtilToProcess(String department,String utilIds){

        // 组装一个表单，记录此次生成的报表
        MeteringApprovalForm form = new MeteringApprovalForm();
        form.setMeteringId(utilIds);
        form.setAffiliateDepartment(department);

        int formId = meteringDealProcessService.addForm(form);
        if(formId == 0){
            return Result.error("报表生成失败！请重试！");
        }

        // 将报表中的计量设备状态改为已经进入计量流程
        String[] ids = utilIds.split(",");
        for(String id : ids){
            meteringService.updateMeteringStatus(Integer.parseInt(id));
        }

        // 生成一个业务流程
        String nowTiem = new SimpleDateFormat("yyyy/MM/dd HH:MM:ss a").format(new Date());
        MeteringDealProcess meteringDealProcess = new MeteringDealProcess();
        meteringDealProcess.setFormId(formId);
        meteringDealProcess.setRecordTime(nowTiem);
        meteringDealProcess.setDealStatus("待处理");
        meteringDealProcess.setDepartment(department);
        meteringDealProcess.setProcessName(nowTiem + "生成的报表(" + department +")");
        int result = meteringDealProcessService.addProcess(meteringDealProcess);
        if(result == 0){
            return Result.error("报表流程生成失败！请重试！");
        }

        return Result.success(1,"添加成功！");
    }


    /**
     * 多条件联合查询计量报表
     * @param recordBeginTime 报表生成时间开始的范围
     * @param recordEndTime 报表生成时间结束的范围
     *             这两个参数决定了报表是在那个时间段生成的
     *
     * @param department  报表所属部门
     *
     * @param status 报表状态：已处理，未处理
     *
     * @param dealBeginTime 处理时间的开始范围
     * @param dealEndTime 处理时间的结束范围
     *             这两个参数限定了报表处理的时间范围
     * @return
     */
    @RequestMapping("/searchApprovalForm.do")
    public Result searchApprovalForm(String recordBeginTime, String recordEndTime, String department, String status, String dealBeginTime,String dealEndTime){
        List<MeteringApprovalForm> meteringApprovalFormList = meteringDealProcessService.searchApprovalForm(recordBeginTime, recordEndTime, department, status, dealBeginTime, dealEndTime);
        if(meteringApprovalFormList.isEmpty()){
            return Result.error("未查询到任何数据");
        }
        return Result.success(meteringApprovalFormList);
    }


    /**
     * 多条件联合查询计量报表的流程
     * @param recordBeginTime 报表流程生成时间开始的范围
     * @param recordEndTime 报表流程生成时间结束的范围
     *             这两个参数决定了报表流程是在那个时间段生成的
     *
     * @param department  报表流程所属部门
     *
     * @param status 报表流程状态：已处理，未处理
     *
     * @param dealBeginTime 处理时间的开始范围
     * @param dealEndTime 处理时间的结束范围
     *             这两个参数限定了报表流程处理的时间范围
     * @return
     */
    @RequestMapping("/searchFormProcess.do")
    public Result searchFormProcess(String recordBeginTime, String recordEndTime, String department, String status, String dealBeginTime,String dealEndTime){
        List<MeteringDealProcess> meteringDealProcessList = meteringDealProcessService.searchFormProcess(recordBeginTime, recordEndTime, department, status, dealBeginTime, dealEndTime);
        if(meteringDealProcessList.isEmpty()){
            return Result.error("未查询到任何数据");
        }
        return Result.success(meteringDealProcessList);
    }


    /**
     * 得到流程的详细信息
     * @param ProcessId 流程的id
     * @return
     */
    @RequestMapping("/getProcessMoreInfomation.do")
    public Result getProcessMoreInfomation(int ProcessId){
        MeteringDealProcess process = meteringDealProcessService.selectMeteringDealProcessByPrimaryKey(ProcessId);
        MeteringApprovalForm form = meteringDealProcessService.findFormByFormID(process.getFormId());
        List<MeteringUtil> utils = meteringDealProcessService.findUtilByProcess(form.getMeteringId());
        MeteringProcessMoreInformationVo vo = new MeteringProcessMoreInformationVo(process);
        vo.setForms(utils);
        return Result.success(vo);
    }


    /**
     * 得到报表的详细信息
     * @param formID 表单id
     * @return
     */
    @RequestMapping("/getFormMoreInfomation.do")
    public Result getFormMoreInfomation(int formID){
        MeteringApprovalForm form = meteringDealProcessService.findFormByFormID(formID);
        List<MeteringUtil> utils = meteringDealProcessService.findUtilByProcess(form.getMeteringId());
        MeteringApprovalFormMoreInfomationVo vo = new MeteringApprovalFormMoreInfomationVo(form);
        vo.setUtils(utils);
        return Result.success(vo);
    }


    /**
     * 审批
     * @param processId
     * @param dealPerson
     * @param dealAdvertisement
     * @return
     */
    @RequestMapping("/Approval.do")
    public Result Approval(int processId,String dealPerson,String dealAdvertisement){
        MeteringDealProcess process = meteringDealProcessService.selectMeteringDealProcessByPrimaryKey(processId);
        process.setDealPerson(dealPerson);
        process.setDealAdvertisement(dealAdvertisement);

        MeteringApprovalForm form = meteringDealProcessService.findFormByFormID(process.getFormId());
        String nowTime = new SimpleDateFormat("yyyy/MM/dd hh:MM:ss a").format(new Date());
        process.setDealStatus("已处理");
        process.setDealTime(nowTime);

        form.setDealStatus("已处理");
        form.setDealTime(nowTime);

        meteringDealProcessService.updateProcessByPrimaryKeySelective(process);
        meteringDealProcessService.updateFormByPrimaryKeySelective(form);

        return Result.success();
    }







}
