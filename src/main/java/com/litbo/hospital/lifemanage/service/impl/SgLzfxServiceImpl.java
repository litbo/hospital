package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgLzfxMapper;
import com.litbo.hospital.lifemanage.service.SgLzfxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 论证分析表Service实现类
 */
@Service
public class SgLzfxServiceImpl implements SgLzfxService {
    @Autowired
    private SgLzfxMapper sgLzfxMapper;
}
