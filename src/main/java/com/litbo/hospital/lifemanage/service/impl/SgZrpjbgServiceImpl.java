package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgZrpjbgMapper;
import com.litbo.hospital.lifemanage.service.SgZrpjbgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 准入评价报告表Service实现类
 */
@Service
public class SgZrpjbgServiceImpl implements SgZrpjbgService {
    @Autowired
    private SgZrpjbgMapper sgZrpjbgMapper;
}
