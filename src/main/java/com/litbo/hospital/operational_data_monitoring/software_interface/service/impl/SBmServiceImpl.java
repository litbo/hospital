package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.SBmDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.SBmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-27 16:58
 * @Description: todo
 */
@Service
public class SBmServiceImpl implements SBmService {

    @Autowired
    private SBmDAO dao;

    @Override
    public PageInfo showBm(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectBy(name));
    }
}
