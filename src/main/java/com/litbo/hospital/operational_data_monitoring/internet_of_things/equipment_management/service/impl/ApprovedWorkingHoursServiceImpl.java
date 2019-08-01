package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.ApprovedWorkingHoursVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.bean.ApprovedWorkingHours;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao.ApprovedWorkingHoursDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.ApprovedWorkingHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-22 16:10
 * @Description: todo
 */
@Service
@Transactional
public class ApprovedWorkingHoursServiceImpl implements ApprovedWorkingHoursService {
    @Autowired
    private ApprovedWorkingHoursDAO dao;

    @Override
    public void save(ApprovedWorkingHours approvedWorkingHours) {
        dao.save(approvedWorkingHours);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public void deletes(List<String> ids) {
        dao.deleteByIds(Arrays.asList("2"));
    }

    @Override
    public PageInfo selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll());
    }

    @Override
    public PageInfo showEqApproBy(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAllBy(searchVO));
    }

    @Override
    public ApprovedWorkingHoursVO getById(String id) {
        return dao.selectById(id);
    }

    @Override
    public void update(ApprovedWorkingHours approvedWorkingHours) {
        dao.update(approvedWorkingHours);
    }
}
