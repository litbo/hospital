package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqOvertimeVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqOvertimeTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.dao.EqOvertimeTabDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqOvertimeTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-22 15:09
 * @Description: todo
 */
@Service
@Transactional
public class EqOvertimeTabServiceImpl implements EqOvertimeTabService {

    @Autowired
    private EqOvertimeTabDAO eqOvertimeTabDAO;

    /**
     * 新建，添加加班信息
     * @param eqOvertime
     */
    @Override
    public void save(EqOvertimeTab eqOvertime) {
        eqOvertimeTabDAO.save(eqOvertime);
    }

    /**
     * 根据id删除数据
     * @param id
     */
    @Override
    public void delete(String id) {
        eqOvertimeTabDAO.delete(id);
    }

    @Override
    public void deletes(List<String> ids) {
        eqOvertimeTabDAO.deletes(ids);
    }

    @Override
    public PageInfo showAll(Integer pageNum, Integer pageSize) {
        /**开启分页*/
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqOvertimeTabDAO.selectAll());
    }

    @Override
    public PageInfo showAlllBy(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        /**开启分页*/
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqOvertimeTabDAO.selectAllBy(searchVO));
    }

    @Override
    public EqOvertimeVO getById(String id) {
        return eqOvertimeTabDAO.selectById(id);
    }

    @Override
    public void update(EqOvertimeTab eqOvertimeTab) {
        eqOvertimeTabDAO.update(eqOvertimeTab);
    }
}
