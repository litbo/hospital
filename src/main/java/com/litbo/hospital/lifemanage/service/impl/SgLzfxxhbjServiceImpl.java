package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgLzfxxhbjMapper;
import com.litbo.hospital.lifemanage.service.SgLzfxxhbjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 论证分析参考型号及报价表Service实现类
 */
@Service
public class SgLzfxxhbjServiceImpl implements SgLzfxxhbjService {
    @Autowired
    private SgLzfxxhbjMapper sgLzfxxhbjMapper;
}
