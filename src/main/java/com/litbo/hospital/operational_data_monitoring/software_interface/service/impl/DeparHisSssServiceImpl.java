package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.common.utils.DbUtil.IDFormat;
import com.litbo.hospital.operational_data_monitoring.software_interface.bean.DeparHisSss;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.DeparHisSssDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.DeparHisSssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-27 14:44
 * @Description: todo
 */
@Service
public class DeparHisSssServiceImpl implements DeparHisSssService {
    @Autowired
    private DeparHisSssDAO dao;
    @Override
    public PageInfo showDepartment(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.select());
    }

    @Override
    public PageInfo showDepartmentByName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectByName(name));
    }

    @Override
    public void save(DeparHisSss deparHisSss) {
        dao.save(deparHisSss);
    }

    @Override
    public PageInfo showAll(Integer pageNum,
                            Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAll());
    }

    @Override
    public PageInfo showAllBy(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectAllByName(name));
    }

    @Override
    public void delete(String id) {
        dao.deleteBy(id);
    }
}
