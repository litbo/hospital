package com.litbo.hospital.maintenance.dao;

import com.litbo.hospital.maintenance.pojo.MaintenanceProject;

public interface MaintenanceProjectDAO {
    int insert(MaintenanceProject record);

    int insertSelective(MaintenanceProject record);

    MaintenanceProject selectById(int id);

    int getLastId();
}