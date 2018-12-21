package com.litbo.hospital.supervise.service.impl;

import com.litbo.hospital.supervise.bean.SBm;
import com.litbo.hospital.supervise.bean.SEmp;
import com.litbo.hospital.supervise.dao.EmpDao;
import com.litbo.hospital.supervise.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
