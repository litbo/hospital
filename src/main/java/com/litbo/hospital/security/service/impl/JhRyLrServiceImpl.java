package com.litbo.hospital.security.service.impl;

import com.litbo.hospital.security.bean.JhRylr;
import com.litbo.hospital.security.dao.JhRyLrDao;
import com.litbo.hospital.security.service.JhRyLrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zjc
 * @create 2018-12-02 14:55
 * 计划人员录入
 */
@Service
public class JhRyLrServiceImpl implements JhRyLrService {

    @Autowired
    private JhRyLrDao jhRyLrDao;

    @Override
    @Transactional
    public void addJhRyLrList(List<JhRylr> list) {
        for (JhRylr jhRylr : list) {
            jhRyLrDao.addJhRyLr(jhRylr);
        }
    }

    @Override
    public void addOrUpdateJhRyLr(JhRylr jhRylr) {
        if(jhRylr.getId()!=null){
            jhRyLrDao.deleteJhRyLr(jhRylr.getId());
        }
        jhRyLrDao.addJhRyLr(jhRylr);
    }

    @Override
    public List<JhRylr> findJhRyLrByJhId(Integer jhId) {
        List<JhRylr> jhRylrs = jhRyLrDao.getJhRyLrById(jhId);
        return jhRylrs;
    }

    @Override
    public List<JhRylr> findJhRyLrByEmpId(String empId) {
        List<JhRylr> jhRyLrByEmpId = jhRyLrDao.getJhRyLrByEmpId(empId);
        return jhRyLrByEmpId;
    }
}
