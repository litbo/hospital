package com.litbo.hospital.metering.service;

import com.litbo.hospital.metering.pojo.MaintenanceRecords;

import java.util.List;

/**
 * @Author: 樊小铭
 * Date: 2019/8/23 11:06
 * @Version:
 * @Description:
 */
public interface MaintenanceRecordsService {

    int insert(MaintenanceRecords record);

    int deleteByPrimaryKey(int id);

    List<MaintenanceRecords> seeAllRecords(int id);
}
