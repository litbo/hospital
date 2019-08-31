package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgZrpjbg;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.dao.SgZrpjbgMapper;
import com.litbo.hospital.lifemanage.service.SgZrpjbgService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * 准入评价报告表Service实现类
 */
@Service
public class SgZrpjbgServiceImpl implements SgZrpjbgService {
    @Autowired
    private SgZrpjbgMapper sgZrpjbgMapper;
    @Autowired
    private SgInfoMapper sgInfoMapper;

    /**
     * 添加或更新准入评价报告信息
     *
     * @param sgZrpjbg 准入评价报告
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    @Override
    public void insertOrUpdateSgZrpjbg(SgZrpjbg sgZrpjbg) {
        // 查询申购单表是否有准入评价报告id
        String sgZrpjbgId = sgInfoMapper.selectSgZrpjbgBySgInfoId(sgZrpjbg.getSgId());
        if (StringUtils.isBlank(sgZrpjbgId)) {
            sgZrpjbgId = UUID.randomUUID().toString();
            sgZrpjbg.setPjbgId(sgZrpjbgId);
            sgZrpjbgMapper.insertSgZrpjbg(sgZrpjbg);
            //把准入评价报告id插入申购单表中
            sgInfoMapper.updateSgInfoZrpjbgIdById(sgZrpjbgId, sgZrpjbg.getSgId());
        } else {
            //根据查到准入评价报告id 更新准入评价报告表信息
            sgZrpjbg.setPjbgId(sgZrpjbgId);
            sgZrpjbgMapper.updateSgZrpjbgById(sgZrpjbg);
        }
    }

    /**
     * 根据申购单id查询准入评价报告信息
     *
     * @param sgInfoId 申购单id
     * @return 评价报告信息
     */
    @Override
    public SgZrpjbg selectSgZrpjbgBySgInfoId(String sgInfoId) {
        return sgZrpjbgMapper.selectSgZrpjbgBySgInfoId(sgInfoId);
    }
}
