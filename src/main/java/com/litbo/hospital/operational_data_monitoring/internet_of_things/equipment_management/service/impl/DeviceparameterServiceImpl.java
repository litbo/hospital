package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao.DeviceparameterDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.DeviceparameterService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-30 17:26
 * @Description: todo
 */
@Service
public class DeviceparameterServiceImpl implements DeviceparameterService {
    @Autowired
    private DeviceparameterDAO dao;


    @Override
    public PageInfo showEqNetWork(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll());
    }

    @Override
    public DeviceparameterVO showOne(String ip) {
        return dao.selectOne(ip);
    }
}
