package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgTlPmMapper;
import com.litbo.hospital.lifemanage.service.SgTlPmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 讨论申购设备关联表Service实现类
 */
@Service
public class SgTlPmServiceImpl implements SgTlPmService {
    @Autowired
    private SgTlPmMapper sgTlPmMapper;
}
