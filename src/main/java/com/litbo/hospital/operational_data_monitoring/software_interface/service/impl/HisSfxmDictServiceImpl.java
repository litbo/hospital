package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.HisSfxmDictDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.HisSflbService;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.HisSfxmDictService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-27 15:24
 * @Description: todo
 */
@Service
public class HisSfxmDictServiceImpl implements HisSfxmDictService {
    @Autowired
    private HisSfxmDictDAO dao;

    @Override
    public PageInfo showXm(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll());
    }

    @Override
    public PageInfo showXmByName(String name,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAllByName(name));
    }
}
