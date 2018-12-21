package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountSearchCriteriaVO;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import com.litbo.hospital.lifemanage.dao.EquipmentAccountMapper;
import com.litbo.hospital.lifemanage.service.EquipmentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EquipmentAccountServiceImpl
 *
 * @author Administrator on 2018-12-16
 */
@Service
public class EquipmentAccountServiceImpl implements EquipmentAccountService {
    @Autowired
    private EquipmentAccountMapper equipmentAccountMapper;
    /**
     * 分页查询电子台账
     *
     * @param machineAccountSearchCriteriaVO 查询条件
     * @return PageInfo<MachineAccountVO>
     */
    @Override
    public PageInfo<MachineAccountVO> selectEquipmentAccount(MachineAccountSearchCriteriaVO machineAccountSearchCriteriaVO) {
        List<MachineAccountVO> machineAccountVOS = equipmentAccountMapper.selectEquipmentAccount(machineAccountSearchCriteriaVO);

        return new PageInfo<>(machineAccountVOS);
    }
}
