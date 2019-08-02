package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.PacsSflbDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.PacsSflbService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-27 11:55
 * @Description: todo
 */
@Service
public class PacsSflbServiceImpl implements PacsSflbService {
    @Autowired
    private PacsSflbDAO dao;
    @Override
    public PageInfo showPacsSflbByTime(Integer pageNum, Integer pageSize, SearchVO searchVO) {
        PageHelper.startPage(1,10);
        System.out.println(searchVO);
//        System.out.println(dao.selectByTime(searchVO).get(0));
        System.out.println(dao.selectByTime(searchVO).size());
        return new PageInfo(dao.selectByTime(searchVO));
    }
}
