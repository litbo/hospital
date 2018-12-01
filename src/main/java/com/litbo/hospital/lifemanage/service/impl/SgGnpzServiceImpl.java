package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgGnpzMapper;
import com.litbo.hospital.lifemanage.service.SgGnpzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能配置表Service实现类
 */
@Service
public class SgGnpzServiceImpl implements SgGnpzService {
    @Autowired
    private SgGnpzMapper sgGnpzMapper;
}
