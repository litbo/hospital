package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.EqInfoDAO2;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.EqInfoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-27 17:27
 * @Description: todo
 */
@Service
public class EqInfoService2Impl implements EqInfoService2 {
    @Autowired
    private EqInfoDAO2 eqInfoDAO;
    @Override
    public PageInfo showEqInfo(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqInfoDAO.selectAllBy(name));
    }
}
