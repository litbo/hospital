package com.litbo.hospital.lifemanage.service.impl;

import com.github.pagehelper.PageInfo;
import com.litbo.hospital.lifemanage.bean.SgLzfx;
import com.litbo.hospital.lifemanage.bean.SgLzfxxhbj;
import com.litbo.hospital.lifemanage.bean.vo.SgLzfxVO;
import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.dao.SgLzfxMapper;
import com.litbo.hospital.lifemanage.dao.SgLzfxxhbjMapper;
import com.litbo.hospital.lifemanage.service.SgLzfxService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * 论证分析表Service实现类
 */
@Service
public class SgLzfxServiceImpl implements SgLzfxService {
    @Autowired
    private SgLzfxMapper sgLzfxMapper;
    @Autowired
    private SgLzfxxhbjMapper sgLzfxxhbjMapper;
    @Autowired
    private SgInfoMapper sgInfoMapper;

    /**
     * 添加论证分析信息
     *
     * @param sgLzfxVOs 论证分析信息
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    @Override
    public void insertSgLzfx(SgLzfxVO sgLzfxVOs) {
        String sgLzfxId = UUID.randomUUID().toString();
        SgLzfx sgLzfx = new SgLzfx();
        BeanUtils.copyProperties(sgLzfxVOs,sgLzfx);
        sgLzfx.setLzfxId(sgLzfxId);
        sgLzfxMapper.insertSgLzfx(sgLzfx);
        //把论证分析表id插入申购表
        sgInfoMapper.updateSgInfoSgLzfxIdById(sgLzfx.getSgId(),sgLzfxId);
        List<SgLzfxxhbj> sgLzfxxhbjs = sgLzfxVOs.getXhbjs();
        //添加论证分析参考型号及报价表信息
        for (SgLzfxxhbj sgLzfxxhbj:sgLzfxxhbjs){
            sgLzfxxhbj.setLzfxId(sgLzfxId);
            sgLzfxxhbj.setXhbjId(UUID.randomUUID().toString());
            sgLzfxxhbjMapper.insertSgLzfxxhbj(sgLzfxxhbj);
        }
    }

    /**
     * 查看论证分析详情
     * @param sgInfoId 申购单id
     * @return SgLzfxVO
     */
    @Override
    public SgLzfxVO selectSgLzfx(String sgInfoId) {
        return sgLzfxMapper.selectSgLzfx(sgInfoId);
    }
}
