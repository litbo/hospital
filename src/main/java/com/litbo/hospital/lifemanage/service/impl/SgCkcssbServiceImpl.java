package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgCkcssb;
import com.litbo.hospital.lifemanage.dao.SgCkcssbMapper;
import com.litbo.hospital.lifemanage.service.SgCkcssbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 参考厂商设备表Service实现类
 */
@Service
public class SgCkcssbServiceImpl implements SgCkcssbService {
    @Autowired
    private SgCkcssbMapper sgCkcssbMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<SgCkcssb> selectSgCkcssbs() {
        return sgCkcssbMapper.selectSgCkcssbs();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int insertSgCkcssb(SgCkcssb sgCkcssb) {
        return sgCkcssbMapper.insertSgCkcssb(sgCkcssb);
    }
}
