package com.litbo.hospital.supervise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.EmpDao;
import com.litbo.hospital.supervise.service.EmpService;
import com.litbo.hospital.supervise.vo.EmpSelectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public List<SEmp> getWxEmps() {
        return empDao.getWxEmps();
    }

    @Override
    public List<SEmp> getEmpsByBmId(String bmId) {
        return empDao.getEmpsByBmId(bmId);
    }

    @Override
    public void saveEmp(SEmp emp) {
        empDao.saveEmp(emp);
    }

    @Override
    public void deleteEmpByUserId(String empId) {
        empDao.deleteEmpByUserId(empId);
    }

    @Override
    public SBm getBmByEmpId(String empId) {
        return empDao.getBmByEmpId(empId);
    }

    @Override
    public SEmp getEmpsById(String id) {
        return empDao.getEmpsById(id);
    }

    @Override
    public List<SEmp> listEmpByBmId(String bmId) {

        return empDao.listEmpByBmId(bmId);
    }

    @Override
    public PageInfo listSelectEmps(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmpSelectVO> emps = empDao.listSelectEmps();
        return new PageInfo(emps);
    }

    @Override
    public PageInfo listSelectEmpBybmIdAndUserId(int pageNum, int pageSize, String bmId, String userId) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmpSelectVO> emps = empDao.listSelectEmpBybmIdAndUserId(bmId,userId);
        return new PageInfo(emps);
    }

    @Override
    public List<SEmp> listPartnerByUserId(String userId) {
        List<SEmp> partners = empDao.listPartnerByUserId(userId);
        Iterator<SEmp> iterator = partners.iterator();

        return partners;
    }
}
