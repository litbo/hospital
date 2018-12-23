package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.EquipmentStoppedListVO;
import com.litbo.hospital.lifemanage.dao.EmergencyMapper;
import com.litbo.hospital.lifemanage.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EmergencyServiceImpl
 *
 * @author Administrator on 2018-12-17
 */
@Service
public class EmergencyServiceImpl implements EmergencyService {
    @Autowired
    private EmergencyMapper emergencyMapper;

    /**
     * 查询本科室所有设备
     *
     * @param userId 用户id
     * @return PageInfo<EquipmentStoppedListVO>
     */
    @Override
    public PageInfo<EquipmentStoppedListVO> selectEmergencyList(String userId) {
        //TODO 通过用户id查询部门id
        String bmId = "1";
        String bmName = "部门1";

        List<EquipmentStoppedListVO> equipmentStoppedListVOS = emergencyMapper.selectEmergencyList(bmId);
        for (EquipmentStoppedListVO e : equipmentStoppedListVOS){
            e.setBmName(bmName);
        }
        return new PageInfo<>(equipmentStoppedListVOS);
    }
}
