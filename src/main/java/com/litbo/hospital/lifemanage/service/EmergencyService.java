package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.EquipmentStoppedListVO;

/**
 * 应急管理Service
 *
 * @author Administrator on 2018-12-17
 */
public interface EmergencyService {
    /**
     * 查询本科室所有设备
     * @param userId 用户id
     * @return PageInfo<EquipmentStoppedListVO>
     */
    PageInfo<EquipmentStoppedListVO> selectEmergencyList(String userId);
}
