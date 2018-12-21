package com.litbo.hospital.lifemanage.service;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountSearchCriteriaVO;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;

/**
 * 电子台账Service
 *
 * @author Administrator on 2018-12-16
 */
public interface EquipmentAccountService {
    /**
     * 分页查询电子台账
     *
     * @param machineAccountSearchCriteriaVO 查询条件
     * @return PageInfo<MachineAccountVO>
     */
    PageInfo<MachineAccountVO> selectEquipmentAccount(MachineAccountSearchCriteriaVO machineAccountSearchCriteriaVO);
}
