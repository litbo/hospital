package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgDjhwMapper;
import com.litbo.hospital.lifemanage.service.SgDjhwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SgDjhwServiceImpl implements SgDjhwService {
    @Autowired
    private SgDjhwMapper sgDjhwMapper;
}
