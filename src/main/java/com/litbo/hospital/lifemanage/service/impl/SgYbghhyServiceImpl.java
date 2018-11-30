package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgYbghhyMapper;
import com.litbo.hospital.lifemanage.service.SgYbghhyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SgYbghhyServiceImpl implements SgYbghhyService {
    @Autowired
    private SgYbghhyMapper sgYbghhyMapper;
}
