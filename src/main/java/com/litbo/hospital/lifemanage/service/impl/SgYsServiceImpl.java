package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgYsMapper;
import com.litbo.hospital.lifemanage.service.SgYsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商务/临床/技术验收表Service实现类
 */
@Service
public class SgYsServiceImpl implements SgYsService {
    @Autowired
    private SgYsMapper sgYsMapper;
}
