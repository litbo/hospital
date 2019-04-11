package com.litbo.hospital.supervise.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.vo.EmpSelectVO;
import com.litbo.hospital.supervise.vo.EmpVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmpService {
    //获取所有维修人员
    List<SEmp> getWxEmps();
    //通过部门获取员工
    List<SEmp> getEmpsByBmId(String bmId);
    //通过员工id获取员工信息
    SEmp getEmpsById(String id);
    //通过姓名获取人员id
    String getIdByXm(String xm);
    //保存员工
    void saveEmp(SEmp emp);
    //删除员工
    void deleteEmpByUserId(String empId);
    //通过成员id获得部门信息w
    SBm getBmByEmpId(String empId);
    //通过部门id获得员工信息
    List<SEmp> listEmpByBmId(String bmId);
    //获取Emp基本信息
    PageInfo listSelectEmps(int pageNum, int pageSize);
    //获取Emp基本信息通过部门id和userId status
    PageInfo listSelectEmpBybmIdAndUserId(int pageNum, int pageSize, String bmId, String userId,String status,String bmName);


    //获取登陆人的同部门伙伴信息
    List<SEmp> listPartnerByUserId(String userId,int pageNum,int pageSize);

    EmpVO getEmpsByUserId(String userId);

    void updateEmp(SEmp emp);

    Integer batchImportBms(String fileName, MultipartFile file) throws Exception;

    EmpSelectVO listSelectEmpsByUserId(String userId);

    List<SEmp> listBmPartnerByUserId(String userId, int pageNum, int pageSize);

    List<EmpSelectVO> listSelectEmpsByUserName(int pageNum, int pageSize, String userName);

    String setQzzp(MultipartFile img);
}
