package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgYsMapper;
import com.litbo.hospital.lifemanage.service.SgYsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SgYsServiceImpl implements SgYsService {
    @Autowired
    private SgYsMapper sgYsMapper;
}
