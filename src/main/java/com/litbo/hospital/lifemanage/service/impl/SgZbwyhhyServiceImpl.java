package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgZbwyhhyMapper;
import com.litbo.hospital.lifemanage.service.SgZbwyhhyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 装备委员会会议信息表Service实现类
 */
@Service
public class SgZbwyhhyServiceImpl implements SgZbwyhhyService {
    @Autowired
    private SgZbwyhhyMapper SgZbwyhhyMapper;
}
