package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import com.litbo.hospital.lifemanage.dao.SgCkcssbMapper;
import com.litbo.hospital.lifemanage.service.SgCkcssbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * 参考厂商设备表Service实现类
 */
@Service
public class SgCkcssbServiceImpl implements SgCkcssbService {
    @Autowired
    private SgCkcssbMapper sgCkcssbMapper;

    /**
     * 分页查询所有参考厂商设备表信息
     *
     * @return List<SgCkcssb> 查询的信息
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<SgCkcssb> selectSgCkcssbBySgInfoId(String sgInfoId) {
        return sgCkcssbMapper.selectSgCkcssbBySgInfoId(sgInfoId);
    }

    /**
     * 添加厂商设备表信息
     *
     * @param sgCkcssb 参考厂商设备表实体类
     * @return boolean 是否添加信息成功
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean insertSgCkcssb(SgCkcssb sgCkcssb) {
        //添加参考厂商ID
        sgCkcssb.setCkcssbId(UUID.randomUUID().toString());
        return sgCkcssbMapper.insertSgCkcssb(sgCkcssb) > 0;
    }
}
