package com.litbo.hospital.supervise.service;

import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;

import java.util.List;

public interface EmpService {
    //获取所有维修人员
    List<SEmp> getWxEmps();
    //通过部门获取员工
    List<SEmp> getEmpsByBmId(String bmId);
    //通过员工id获取员工信息
    SEmp getEmpsById(String id);
    //保存员工
    void saveEmp(SEmp emp);
    //删除员工
    void deleteEmpByUserId(String empId);
    //通过成员id获得部门信息
    SBm getBmByEmpId(String empId);
}
