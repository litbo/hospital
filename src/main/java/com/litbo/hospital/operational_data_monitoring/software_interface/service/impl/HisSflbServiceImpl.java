package com.litbo.hospital.operational_data_monitoring.software_interface.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.software_interface.dao.HisSflbDAO;
import com.litbo.hospital.operational_data_monitoring.software_interface.service.HisSflbService;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HISCycle;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.HisSflbVO;
import com.litbo.hospital.operational_data_monitoring.software_interface.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.software_interface.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-27 11:42
 * @Description: todo
 */
@Service
public class HisSflbServiceImpl implements HisSflbService {

    @Autowired
    private HisSflbDAO dao;

    /**
     * 根据条件显示his收费列表
     * @param pageNum
     * @param pageSize
     * @param searchVO
     * @return
     */
    @Override
    public PageInfo showHisSflbByTime(
            Integer pageNum,
            Integer pageSize,
            SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        System.out.println("service"+searchVO);
        System.out.println("service查到"+dao.selectByTime(searchVO).size());
        return new PageInfo(dao.selectByTime(searchVO));
    }
}
