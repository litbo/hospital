package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.bean.SgZrpjbg;
import com.litbo.hospital.lifemanage.dao.SgZrpjbgMapper;
import com.litbo.hospital.lifemanage.service.SgZrpjbgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 准入评价报告表Service实现类
 */
@Service
public class SgZrpjbgServiceImpl implements SgZrpjbgService {
    @Autowired
    private SgZrpjbgMapper sgZrpjbgMapper;

    /**
     * 添加准入评价报告信息
     *
     * @param sgZrpjbg 准入评价报告
     */
    @Override
    public void insertSgZrpjbg(SgZrpjbg sgZrpjbg) {
        sgZrpjbg.setPjbgId(UUID.randomUUID().toString());
        sgZrpjbgMapper.insertSgZrpjbg(sgZrpjbg);
    }
}
