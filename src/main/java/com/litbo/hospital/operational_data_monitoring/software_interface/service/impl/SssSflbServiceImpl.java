package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.SssSflbDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.SssSflbService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-27 14:01
 * @Description: todo
 */
@Service
public class SssSflbServiceImpl implements SssSflbService {
    @Autowired
    private SssSflbDAO dao;

    @Override
    public PageInfo showSssSflbByTime(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(dao.selectByTime(searchVO));
    }
}
