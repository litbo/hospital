package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgLssqMapper;
import com.litbo.hospital.lifemanage.service.SgLssqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SgLssqServiceImpl implements SgLssqService {
    @Autowired
    private SgLssqMapper sgLssqMapper;
}
