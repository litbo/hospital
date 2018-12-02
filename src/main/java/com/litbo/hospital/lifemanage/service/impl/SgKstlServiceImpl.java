package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgKstlMapper;
import com.litbo.hospital.lifemanage.service.SgKstlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 科室讨论表Service实现类
 */
@Service
public class SgKstlServiceImpl implements SgKstlService {
    @Autowired
    private SgKstlMapper sgKstlMapper;
}
