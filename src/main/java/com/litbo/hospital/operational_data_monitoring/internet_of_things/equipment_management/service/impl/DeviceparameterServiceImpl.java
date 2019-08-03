package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqMacVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao.DeviceparameterDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.DeviceparameterService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.DeviceparameterVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
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
    public PageInfo showEqNetWork(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll(searchVO));
    }


    @Override
    public DeviceparameterVO showOne(EqMacVO eqMacVO) {
        return dao.selectOne(eqMacVO);
    }

    @Override
    public void deleteByMacId(SearchVO searchVO) {
        dao.delete(searchVO.getMacid());
        dao.update(searchVO.getEqZcbh());
    }

    @Override
    public void save(DeviceparameterVO deviceparameterVO) {
        dao.save(deviceparameterVO);
    }
}
