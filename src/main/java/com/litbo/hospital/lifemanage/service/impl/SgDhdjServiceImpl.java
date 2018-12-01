package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgDhdjMapper;
import com.litbo.hospital.lifemanage.service.SgDhdjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 到货登记表Service实现类
 */
@Service
public class SgDhdjServiceImpl implements SgDhdjService {
    @Autowired
    private SgDhdjMapper sgDhdjMapper;
}
