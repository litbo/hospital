package com.litbo.hospital.metering.service.impl;

import com.litbo.hospital.metering.dao.MaintenanceRecordsDAO;
import com.litbo.hospital.metering.pojo.MaintenanceRecords;
import com.litbo.hospital.metering.service.MaintenanceRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/23 11:06
 * @Version:
 * @Description:
 */
@Service
public class MaintenanceRecordsServiceImpl implements MaintenanceRecordsService {

    @Autowired
    private MaintenanceRecordsDAO maintenanceRecordsDAO;

    @Override
    public int insert(MaintenanceRecords record) {
        return maintenanceRecordsDAO.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return maintenanceRecordsDAO.deleteByPrimaryKey(id);
    }

    @Override
    public List<MaintenanceRecords> seeAllRecords(int id) {
        return maintenanceRecordsDAO.seeAllRecords(id);
    }
}
