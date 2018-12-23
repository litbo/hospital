package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgKxxfx;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.dao.SgKxxfxMapper;
import com.litbo.hospital.lifemanage.service.SgKxxfxService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * 可行性分析表Service实现类
 */
@Service
public class SgKxxfxServiceImpl implements SgKxxfxService {
    @Autowired
    private SgKxxfxMapper sgKxxfxMapper;
    @Autowired
    private SgInfoMapper sgInfoMapper;

    /**
     * 添加或更新可行性分析表信息
     *
     * @param sgKxxfx 可行性分析信息
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    @Override
    public void insertOrUpdateSgKxxfx(SgKxxfx sgKxxfx) {
        // 查询申购单表是否有可行性分析id
        String sgKxxfxId = sgInfoMapper.selectSgKxxfxBySgInfoId(sgKxxfx.getSgId());
        if (StringUtils.isBlank(sgKxxfxId)) {
            sgKxxfxId = UUID.randomUUID().toString();
            sgKxxfx.setKxfxId(sgKxxfxId);
            sgKxxfxMapper.insertSgKxxfx(sgKxxfx);
            //把可行性分析id插入申购单表中
            sgInfoMapper.updateSgInfoKxfxIdById(sgKxxfxId, sgKxxfx.getSgId());
        } else {
            //根据查到可行性分析id 更新可行性分析表信息
            sgKxxfx.setKxfxId(sgKxxfxId);
            sgKxxfxMapper.updateSgKxxfxById(sgKxxfx);
        }
    }

    /**
     * 根据申购单主键查询可行性分析信息
     *
     * @param sgInfoId 申购单主键
     * @return List<SgKxxfx>
     */
    @Override
    public SgKxxfx selectSgKxxfxBySgInfoId(String sgInfoId) {
        return sgKxxfxMapper.selectSgKxxfxBySgInfoId(sgInfoId);
    }
}
