package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgInfoMapper;
import com.litbo.hospital.lifemanage.service.SgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SgInfoServiceImpl implements SgInfoService {
    @Autowired
    private SgInfoMapper sgInfoMapper;
}
