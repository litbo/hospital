package com.litbo.hospital.security.specialequipment.service.serviceimpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipment;
import com.litbo.hospital.security.specialequipment.dao.SpecialEquipmentCheckDao;
import com.litbo.hospital.security.specialequipment.dao.SpecialEquipmentMapper;
import com.litbo.hospital.security.specialequipment.service.SpecialEquipmentCheckService;
import com.litbo.hospital.security.specialequipment.utils.DateUtils;
import com.litbo.hospital.security.specialequipment.utils.GenerateId;
import com.litbo.hospital.user.vo.LiveEmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SpecialEquipmentCheckServiceImpl implements SpecialEquipmentCheckService {


    @Autowired
    private SpecialEquipmentCheckDao
            specialEquipmentCheckDao;


    @Autowired
    private SpecialEquipmentMapper
            specialEquipmentMapper;


    /**
     *
     *      特种设备申请模块
     *
     */

    //查询所有特种设备检测申请信息
    public PageInfo selectSpecialEquipmentCheckVoBy0(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(specialEquipmentCheckDao.selectSpecialEquipmentCheckVoBy0());
    }
    //查询所有特种设备检测申请信息name 科室 生产商
    @Override
    public PageInfo selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy0(int pageNum, int pageSize, String speqBh,String speqName, String bmId, String speqScs) {
        PageHelper.startPage(pageNum, pageSize);
        bmId = specialEquipmentCheckDao.selectBmName(bmId);
        if(bmId == null){
            bmId = "";
        }
        return new PageInfo(specialEquipmentCheckDao.selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy0(speqBh == null ? null :speqBh.trim(),
                speqName== null ? null :speqName.trim(), bmId == null ? null :bmId.trim(), speqScs== null ? null :speqScs.trim()));
    }
    //同意送检申请
    @Override
    public void applicationForInspection(String[] speqIds, LiveEmpVo liveEmpVo) {
        String userXm = liveEmpVo.getUserXm();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        for (String speqId : speqIds) {
            specialEquipmentCheckDao.applicationForInspection(speqId, format, userXm);
        }
    }


    /**
     *
     *      特种设备审批模块
     *
     */

    //查询所有特种设备检测待审批信息
    public PageInfo selectSpecialEquipmentCheckVoBy1(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(specialEquipmentCheckDao.selectSpecialEquipmentCheckVoBy1());
    }
    //查询所有特种设备检测待审批信息name 科室 生产商
    @Override
    public PageInfo selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy1(int pageNum, int pageSize,String speqBh, String speqName, String bmId, String speqScs) {
        PageHelper.startPage(pageNum, pageSize);
        bmId = specialEquipmentCheckDao.selectBmName(bmId);
        if(bmId == null){
            bmId = "";
        }
        return new PageInfo(specialEquipmentCheckDao.selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy1(speqBh,speqName, bmId, speqScs));
    }
    //同意送检审批
    @Override
    public void applicationForApprove(String[] speqIds, LiveEmpVo liveEmpVo) {
        String userXm = liveEmpVo.getUserXm();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        for (String speqId : speqIds) {
            specialEquipmentCheckDao.applicationForApprove(speqId, format, userXm);
        }

    }


    /**
     *
     *      特种设备结果录入模块
     *
     */

    //查询所有特种设备待录入结果
    public PageInfo selectSpecialEquipmentCheckVoBy2(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(specialEquipmentCheckDao.selectSpecialEquipmentCheckVoBy2());
    }
    //查询所有特种设备待录入结果name 科室 生产商
    @Override
    public PageInfo selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy2(int pageNum, int pageSize, String speqBh, String speqName, String bmId, String speqScs) {
        PageHelper.startPage(pageNum, pageSize);
        bmId = specialEquipmentCheckDao.selectBmName(bmId);
        if(bmId == null){
            bmId = "";
        }
        return new PageInfo(specialEquipmentCheckDao.selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy2(speqBh, speqName, bmId, speqScs));
    }
    //  1、接收specialEquipment对象
    //	2、更新数据 run 检测时间 检测证编号 计划检测时间 sjsp sjsq
    //	3、自动生成speqrecord的id并插入record表中
    //	4、将specialEquipment对象中的数据插入record中根据record的id进行update
    //            speq_id,speq_jcsj,speq_jczbh,speq_sjsqr,
    //            speq_sjsqsj,speq_sjspr,speq_sjspsj,speq_run
    @Override
    @Transactional
    public int inspectionResultInput(SpecialEquipment specialEquipment) {

        //	2、更新数据 run 检测时间 检测证编号 计划检测时间 sjsp sjsq
        //    2.1 run 检测证编号用户输入数据更新
        //    2.2 检测时间是结果录入时间 计划检测时间 sjsp sjsq 由后台更新
        specialEquipment.setSpeqJcsj(new Date());
        specialEquipment.setSpeqJhjcrq(DateUtils.DateAddUseMonth(specialEquipment.getSpeqJcsj(), specialEquipment.getSpeqJczq()));
        specialEquipment.setSpeqSjsp(0);
        specialEquipment.setSpeqSjsq(0);
        specialEquipmentMapper.updateByPrimaryKey(specialEquipment);

        //	3、自动生成speqrecord的id并插入record表中
        String speq_jglrid = GenerateId.getIdByIDAndTime("special_eq_record", "speq_jglrid");
        specialEquipmentCheckDao.insertSpeqRecordId(speq_jglrid);

        //	4、将specialEquipment对象中的数据插入record中根据record的id进行update
        //      speq_id,speq_jcsj,speq_jczbh,speq_sjsqr,
        //      speq_sjsqsj,speq_sjspr,speq_sjspsj,speq_run
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = simpleDateFormat.format(specialEquipment.getSpeqJcsj());
        String format2 = simpleDateFormat.format(specialEquipment.getSpeqSjsqsj());
        String format3 = simpleDateFormat.format(specialEquipment.getSpeqSjspsj());
        return specialEquipmentCheckDao.updateSpeqRecordOther(specialEquipment.getSpeqBh(), format1,
                specialEquipment.getSpeqJczbh(), specialEquipment.getSpeqSjsqr(),
                format2, specialEquipment.getSpeqSjspr(),
                format3, specialEquipment.getSpeqRun(),
                speq_jglrid);


    }
}
