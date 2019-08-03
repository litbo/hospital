package com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.EqInfoVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.VO.SearchVO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.dao.EqInfoDAO;
import com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.EqInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @BelongsProject: hospital
 * @BelongsPackage: com.litbo.hospital.operational_data_monitoring.internet_of_things.equipment_management.service.impl
 * @Author: looli
 * @CreateTime: 2019-07-22 13:53
 * @Description: 查询设备表的操作
 */
@Service
@Transactional
public class EqInfoServiceImpl implements EqInfoService {

    @Autowired
    private EqInfoDAO eqInfoDAO;

    @Override
    public PageInfo selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo(eqInfoDAO.selectAll());
    }

    @Override
    public PageInfo selectAllBy(Integer pageNum, Integer pageSize,SearchVO searchVO) {
        PageHelper.startPage(pageNum,pageSize);
        List<EqInfoVO> eqInfoVOS = eqInfoDAO.selectAllBy(searchVO);
//        System.out.println(eqInfoVOS.size());
        return new PageInfo(eqInfoVOS);
    }
}
