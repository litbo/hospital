package com.litbo.hospital.operational_data_monitoring.operation_record.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.operation_record.dao.InspectdetailDAO;
import com.litbo.hospital.operational_data_monitoring.operation_record.service.InspectdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.operation_record.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-23 10:42
 * @Description: 运行记录显示接口实现
 */
@Service
@Transactional
public class InspectdetailServiceImpl implements InspectdetailService {
    @Autowired
    private InspectdetailDAO dao;
    @Override
    public PageInfo showRunningRecord(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll1());
    }

    @Override
    public PageInfo showOriginalRecord(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll2());
    }

    @Override
    public PageInfo showEqRunningRecord(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll3());
    }

    @Override
    public PageInfo showBmRunningRecord(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll4());
    }
}
