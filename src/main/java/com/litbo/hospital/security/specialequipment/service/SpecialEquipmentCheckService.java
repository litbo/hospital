package com.litbo.hospital.security.specialequipment.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.security.specialequipment.bean.SpecialEquipment;
import com.litbo.hospital.user.vo.LiveEmpVo;

import java.util.List;


public interface SpecialEquipmentCheckService {

    //查询所有特种设备检测申请信息
    PageInfo selectSpecialEquipmentCheckVoBy0(int pageNum, int pageSize);

    //查询所有特种设备检测申请信息name 科室 生产商
    PageInfo selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy0(int pageNum, int pageSize,
                                                                 String speqBh, String speqName, String bmId, String speqScs);
    //同意送检申请
    void applicationForInspection(String[] speqIds, LiveEmpVo liveEmpVo);


    //查询所有特种设备检测待审批信息
    PageInfo selectSpecialEquipmentCheckVoBy1(int pageNum, int pageSize);
    //查询所有特种设备检测申请信息name 科室 生产商
    PageInfo selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy1(int pageNum, int pageSize,
                                                                 String speqBh, String speqName, String bmId, String speqScs);
    //同意送检申请
    void applicationForApprove(String[] speqIds, LiveEmpVo liveEmpVo);

    //查询所有特种设备待录入结果
    PageInfo selectSpecialEquipmentCheckVoBy2(int pageNum, int pageSize);
    //查询所有特种设备待录入结果name 科室 生产商
    PageInfo selectSpecialEquipmentCheckVoByNameAndBmIdAndScsBy2(int pageNum, int pageSize,
                                                                 String speqBh, String speqName, String bmId, String speqScs);

    //特种设备结果录入第一步更改数据
    //特种设备结果录入第二步记录到记录表中
    int inspectionResultInput(SpecialEquipment specialEquipment);


}
