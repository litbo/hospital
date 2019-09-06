package com.litbo.hospital.check_before_use.service.impl;

import com.litbo.hospital.check_before_use.dao.CheckBeforeUseDAO;
import com.litbo.hospital.check_before_use.dao.CheckBeforeUseDictDAO;
import com.litbo.hospital.check_before_use.dao.CheckBeforeUseProjectDAO;
import com.litbo.hospital.check_before_use.pojo.CheckBeforeUseDict;
import com.litbo.hospital.check_before_use.pojo.CheckBeforeUseProject;
import com.litbo.hospital.check_before_use.service.Check_before_useService;
import com.litbo.hospital.check_before_use.vo.EqInfoCheckBeforeUseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/9/4 20:52
 * @Version:
 * @Description:
 */
@Service
public class Check_before_useServiceImpl implements Check_before_useService {

    @Autowired
    private CheckBeforeUseDAO checkBeforeUseDAO;

    @Autowired
    private CheckBeforeUseProjectDAO projectDAO;

    @Autowired
    private CheckBeforeUseDictDAO dictDAO;

    @Override
    public List<EqInfoCheckBeforeUseVo> seeEqMessage(String eqNum, String bmName, String eqName) {
        if(eqNum != null){
            eqNum = "%" + eqNum + "%";
        }

        if(eqName != null){
            eqName = "%" + eqName + "%";
        }

        if(bmName != null){
            bmName = "%" + bmName + "%";
        }
        return checkBeforeUseDAO.seeEqMessage(eqNum, bmName, eqName);
    }

    @Override
    public List<String> seeAllType(String type) {
        return dictDAO.seeAllType(type);
    }

    @Override
    public int addProject(CheckBeforeUseProject project) {
        int result = dictDAO.selectValueByKey(project.getType(),project.getName());
        if(result == 0){
            dictDAO.insert(new CheckBeforeUseDict(project.getType(),project.getName()));
        }
        result = projectDAO.insert(project);
        if(result == 0){
            return 0;
        }
        return projectDAO.getMaxId();
    }

    @Override
    public int deleteProject(int id) {
        return projectDAO.deleteById(id);
    }
}
