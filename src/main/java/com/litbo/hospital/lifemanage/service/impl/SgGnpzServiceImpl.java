package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgGnpz;
import com.litbo.hospital.lifemanage.dao.SgGnpzMapper;
import com.litbo.hospital.lifemanage.service.SgGnpzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 功能配置表Service实现类
 */
@Service
public class SgGnpzServiceImpl implements SgGnpzService {
    @Autowired
    private SgGnpzMapper sgGnpzMapper;

    /**
     * 添加功能配置
     *
     * @param sgGnpz 功能配置信息
     */
    @Override
    public void insertSgGnpz(SgGnpz sgGnpz) {
        sgGnpz.setGnpzId(UUID.randomUUID().toString());
        sgGnpzMapper.insertSgGnpz(sgGnpz);
    }

    /**
     * 通过参考厂商设备id查询对应的功能配置
     *
     * @param sgCkcssbId 参考厂商设备id
     * @return List<SgGnpz>
     */
    @Override
    public List<SgGnpz> selectSgGnpzBySgCkcssbId(String sgCkcssbId) {
        return sgGnpzMapper.selectSgGnpzBySgCkcssbId(sgCkcssbId);
    }
}
