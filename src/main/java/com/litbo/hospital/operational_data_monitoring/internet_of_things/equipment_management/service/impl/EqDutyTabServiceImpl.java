package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqDutyVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.EqDutyTab;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao.EqDutyTabDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqDutyTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-22 14:12
 * @Description: todo
 */
@Service
@Transactional
public class EqDutyTabServiceImpl implements EqDutyTabService {

    @Autowired
    private EqDutyTabDAO eqDutyTabDAO;

    /**
     * 保存：新建值班记录
     * @param eqDutyTab
     */
    @Override
    public void save(EqDutyTab eqDutyTab) {
        eqDutyTabDAO.save(eqDutyTab);
    }

    /**
     * 根据id删除
     * @param id
     */
    @Override
    public void delete(String id) {
        eqDutyTabDAO.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deletes(List<String> ids) {
        eqDutyTabDAO.deleteByIds(ids);
    }

    /**
     * 查询所有设备值班情况
     * @return
     */
    @Override
    public PageInfo selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDutyTabDAO.selectAll());
    }

    /**
     * 根据条件显示设备值班情况
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @Override
    public PageInfo showEqDutyBy(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqDutyTabDAO.selectAllBy(searchVO));
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public EqDutyVO getById(String id) {
        return eqDutyTabDAO.selectById(id);
    }

    /**
     * 根据id修改
     * @param eqDutyTab
     */
    @Override
    public void update(EqDutyTab eqDutyTab) {
        eqDutyTabDAO.update(eqDutyTab);
    }

}
