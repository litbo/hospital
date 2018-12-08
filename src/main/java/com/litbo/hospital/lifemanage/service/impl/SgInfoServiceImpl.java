package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgInfo;
import com.litbo.hospital.lifemanage.dao.SgCkcssbMapper;
import com.litbo.hospital.lifemanage.dao.SgGnpzMapper;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.service.SgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 申购单表Service实现类
 */
@Service
public class SgInfoServiceImpl implements SgInfoService {
    @Autowired
    private SgInfoMapper sgInfoMapper;
    @Autowired
    private SgCkcssbMapper sgCkcssbMapper;
    @Autowired
    private SgGnpzMapper sgGnpzMapper;

    /**
     * 根据申购单ID查询申购单信息
     * @param sgInfoId 申购单id
     * @return 申购单信息
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public SgInfo selectSgInfoById(String sgInfoId) {
        return sgInfoMapper.selectSgInfoById(sgInfoId);
    }

    /**
     * 添加申购单表
     * @param sgInfo 申购单信息
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insertSgInfo(SgInfo sgInfo) {
        //通过主键更新申购单信息
        sgInfoMapper.updateSgInfoById(sgInfo);
    }
}
