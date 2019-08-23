package com.litbo.hospital.metering.dao;

import com.litbo.hospital.metering.pojo.MaintenanceRecords;

import java.util.List;

public interface MaintenanceRecordsDAO {
    int insert(MaintenanceRecords record);

    int insertSelective(MaintenanceRecords record);

    int deleteByPrimaryKey(int id);

    List<MaintenanceRecords> seeAllRecords(int id);
}