package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgKxxfxMapper;
import com.litbo.hospital.lifemanage.service.SgKxxfxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 可行性分析表Service实现类
 */
@Service
public class SgKxxfxServiceImpl implements SgKxxfxService {
    @Autowired
    private SgKxxfxMapper sgKxxfxMapper;
}
