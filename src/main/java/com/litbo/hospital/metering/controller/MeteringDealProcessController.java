package com.litbo.hospital.metering.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.metering.pojo.MeteringApprovalForm;
import com.litbo.hospital.metering.pojo.MeteringDealProcess;
import com.litbo.hospital.metering.pojo.MeteringUtil;
import com.litbo.hospital.metering.service.MeteringDealProcessService;
import com.litbo.hospital.metering.service.MeteringService;
import com.litbo.hospital.metering.vo.AddSomeMeteringUtilToProcessVo;
import com.litbo.hospital.metering.vo.MeteringApprovalFormMoreInfomationVo;
import com.litbo.hospital.metering.vo.MeteringProcessMoreInformationVo;
import com.litbo.hospital.metering.vo.PageVo;
import com.litbo.hospital.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
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
     *      处理报表的部门
     *      报表中计量设备的id，是个字符串，其中使用','隔开
     * @return
     */
    @RequestMapping("/addSomeMeteringUtilToProcess.do")
    public Result addSomeMeteringUtilToProcess(@RequestBody String content){
        System.out.println(content);
        AddSomeMeteringUtilToProcessVo vo = JSONObject.parseObject(content,AddSomeMeteringUtilToProcessVo.class);

//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = 0 ; i < vo.getUtilIds().size()-1 ;i++){
//            stringBuffer.append(vo.getUtilIds().get(i)).append(",");
//            System.out.println(stringBuffer);
//        }
//        stringBuffer.append(vo.getUtilIds().get(vo.getUtilIds().size()-1));
//        String utilIds = stringBuffer.toString();
        String department = vo.getDepartment();
//        System.out.println(stringBuffer);

        // 组装一个表单，记录此次生成的报表
        MeteringApprovalForm form = new MeteringApprovalForm();
        form.setMeteringId(vo.getUtilIds());
        form.setAffiliateDepartment(department);

        int formId = meteringDealProcessService.addForm(form);
        if(formId == 0){
            return Result.error("报表生成失败！请重试！");
        }

        // 将报表中的计量设备状态改为已经进入计量流程
        String[] ids = vo.getUtilIds().split(",");
        for(String id : ids){
            int result = meteringService.updateMeteringStatus(Integer.parseInt(id));
            if(result == 0){
                return Result.error("未找到设备信息");
            }
        }

        // 生成一个业务流程
        String nowTiem = new SimpleDateFormat("yyyy/MM/dd HH:MM:ss a").format(new Date());
        MeteringDealProcess meteringDealProcess = new MeteringDealProcess();
        meteringDealProcess.setFormId(formId);  // 表单id
        meteringDealProcess.setRecordTime(nowTiem);  // 申请时间
        meteringDealProcess.setDepartment(department); //所属部门
        meteringDealProcess.setDealAdvertisement(vo.getDealAdvertisement()); // 申请人
        meteringDealProcess.setDealPerson(vo.getDealPerson()); // 处理人
        meteringDealProcess.setProcessName(vo.getProcessName()); // 流程名称
        meteringDealProcess.setVerificationUnit(vo.getVerificationUnit()); // 检定单位

        int result = meteringDealProcessService.addProcess(meteringDealProcess);
        if(result == 0){
            return Result.error("报表流程生成失败！请重试！");
        }

        return Result.success(0,"添加成功！");
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
    public PageVo searchApprovalForm(@RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                     @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize,
                                     @RequestParam(name = "recordBeginTime" , defaultValue = "0000/00/00") String recordBeginTime,
                                     @RequestParam(name = "recordEndTime" , defaultValue = "9999/99/99") String recordEndTime,
                                     @RequestParam(name = "department" , defaultValue = "%") String department,
                                     @RequestParam(name = "status",defaultValue = "%") String status,
                                     @RequestParam(name = "dealBeginTime" , defaultValue = "0000/00/00") String dealBeginTime,
                                     @RequestParam(name = "dealEndTime" , defaultValue = "9999/99/99") String dealEndTime){
        if(department.equals("%")){
            department = null;
        }
        if(status.equals("%")){
            status = null;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<MeteringApprovalForm> meteringApprovalFormList = meteringDealProcessService.searchApprovalForm(recordBeginTime, recordEndTime, department, status, dealBeginTime, dealEndTime);
        PageInfo info = new PageInfo(meteringApprovalFormList);
        PageVo vo = new PageVo();
        if(!meteringApprovalFormList.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringApprovalFormList));
            return vo;
        }
        vo.setMsg("error");
        vo.setCode(0);
        return vo;
    }


    /**
     * 多条件联合查询已经处理的计量报表的流程
     * @param recordBeginTime 报表流程生成时间开始的范围
     * @param recordEndTime 报表流程生成时间结束的范围
     *             这两个参数决定了报表流程是在那个时间段生成的
     *
     * @param department  报表流程所属部门
     *
     * @param status 报表流程状态：“”，通过，不通过
     *
     * @param dealBeginTime 处理时间的开始范围
     * @param dealEndTime 处理时间的结束范围
     *             这两个参数限定了报表流程处理的时间范围
     * @return
     */
    @RequestMapping("/searchFormProcess.do")
    public PageVo searchFormProcess(@RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                    @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize,
                                    @RequestParam(name = "recordBeginTime" , defaultValue = "0000/00/00") String recordBeginTime,
                                    @RequestParam(name = "recordEndTime" , defaultValue = "9999/99/99") String recordEndTime,
                                    @RequestParam(name = "department" , defaultValue = "%") String department,
                                    @RequestParam(name = "status",defaultValue = "1") String status,
                                    @RequestParam(name = "dealBeginTime" , defaultValue = "0000/00/00") String dealBeginTime,
                                    @RequestParam(name = "dealEndTime" , defaultValue = "9999/99/99") String dealEndTime){
        if(department.equals("%")){
            department = null;
        }

        if (status.equals("1")){
            status = null;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<MeteringDealProcess> meteringDealProcessList = meteringDealProcessService.searchFormProcess(recordBeginTime, recordEndTime, department, status, dealBeginTime, dealEndTime);
        PageInfo info = new PageInfo(meteringDealProcessList);
        PageVo vo = new PageVo();
        if(!meteringDealProcessList.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringDealProcessList));
            return vo;
        }
        vo.setMsg("没有查询到相关信息");
        vo.setCode(0);
        return vo;
    }


    /**
     * 多条件联合查询未处理的计量报表的流程
     * @param recordBeginTime 报表流程生成时间开始的范围
     * @param recordEndTime 报表流程生成时间结束的范围
     *             这两个参数决定了报表流程是在那个时间段生成的
     * @param department  报表流程所属部门
     * @return
     */
    @RequestMapping("/searchFormProcessNot.do")
    public PageVo searchFormProcessNot(@RequestParam(name = "pageNum" , defaultValue = "1") int pageNum,
                                    @RequestParam(name = "pageSize" , defaultValue = "15") int pageSize,
                                    @RequestParam(name = "recordBeginTime" , defaultValue = "0000/00/00") String recordBeginTime,
                                    @RequestParam(name = "recordEndTime" , defaultValue = "9999/99/99") String recordEndTime,
                                    @RequestParam(name = "department" , defaultValue = "%") String department){
        if(department.equals("%")){
            department = null;
        }


        PageHelper.startPage(pageNum,pageSize);
        List<MeteringDealProcess> meteringDealProcessList = meteringDealProcessService.searchFormProcessNot(recordBeginTime, recordEndTime, department);
        PageInfo info = new PageInfo(meteringDealProcessList);
        PageVo vo = new PageVo();
        if(!meteringDealProcessList.isEmpty()){
            vo.setCode(0);
            vo.setMsg("success");
            vo.setData(vo.new DataEntity((int) info.getTotal(),meteringDealProcessList));
            return vo;
        }
        vo.setMsg("没有查询到相关信息");
        vo.setCode(0);
        return vo;
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

//
//    /**
//     * 得到报表的详细信息
//     * @param formID 表单id
//     * @return
//     */
//    @RequestMapping("/getFormMoreInfomation.do")
//    public Result getFormMoreInfomation(int formID){
//        MeteringApprovalForm form = meteringDealProcessService.findFormByFormID(formID);
//        List<MeteringUtil> utils = meteringDealProcessService.findUtilByProcess(form.getMeteringId());
//        MeteringApprovalFormMoreInfomationVo vo = new MeteringApprovalFormMoreInfomationVo(form);
//        vo.setUtils(utils);
//        return Result.success(vo);
//    }


    /**
     * 审批
     * @return
     */
    @RequestMapping("/Approval.do")
    public Result Approval(int id , String status){

        MeteringDealProcess process = meteringDealProcessService.selectMeteringDealProcessByPrimaryKey(id);
        process.setDealStatus(status);
        String nowTime = new SimpleDateFormat("yyyy/MM/dd hh:MM:ss a").format(new Date());
        process.setDealTime(nowTime);

        meteringDealProcessService.updateProcessByPrimaryKeySelective(process);

        return Result.success();
    }


    /**
     * 删除送检申请
     * @param processId
     * @return
     */
    @RequestMapping("/deleteProcess.do")
    public Result deleteProcess(int processId){

        int i = meteringDealProcessService.deleterProcess(processId);
        if(i == 0){
            return Result.success("删除失败！");
        }
        return Result.success();

    }







}
