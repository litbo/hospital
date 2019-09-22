package com.litbo.hospital.maintenance.dao;

import com.litbo.hospital.maintenance.pojo.MaintenanceProject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaintenanceProjectDAO {
    int insert(MaintenanceProject record);

    int insertSelective(MaintenanceProject record);

    MaintenanceProject selectById(int id);

    int getLastId();

    int deleteProject(int id);

    int updateProject(MaintenanceProject record);

}