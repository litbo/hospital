package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgZbwyhRyMapper;
import com.litbo.hospital.lifemanage.service.SgZbwyhRyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 参加装备委员会会议人员关联表Service实现类
 */
@Service
public class SgZbwyhRyServiceImpl implements SgZbwyhRyService {
    @Autowired
    private SgZbwyhRyMapper sgZbwyhRyMapper;
}
