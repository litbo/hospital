package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.vo.MachineAccountVO;
import com.litbo.hospital.lifemanage.dao.EquipmentAccountMapper;
import com.litbo.hospital.lifemanage.service.EquipmentAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param category            购置类别
     * @param state               状态
     * @param departmentId        部门id
     * @param equipmentPinyinCode 设备拼音码
     * @param departmentCoding    院内编码
     * @param equipmentNumber     设备编码
     * @param pageNum             当前页数
     * @param pageSize            每页显示的条数
     * @return PageInfo<MachineAccountVO>
     */
    @Override
    public PageInfo<MachineAccountVO> selectEquipmentAccount(String category, String state, String departmentId, String equipmentPinyinCode, String departmentCoding, String equipmentNumber, Integer pageNum, Integer pageSize) {
        if (StringUtils.isNotBlank(equipmentPinyinCode)) {
            equipmentPinyinCode = "%"+equipmentPinyinCode+"%";
        }
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(equipmentAccountMapper.selectEquipmentAccount(category, state, departmentId, equipmentPinyinCode, departmentCoding, equipmentNumber));
    }
}
