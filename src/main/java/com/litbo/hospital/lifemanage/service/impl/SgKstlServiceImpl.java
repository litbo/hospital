package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgKstlMapper;
import com.litbo.hospital.lifemanage.service.SgKstlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SgKstlServiceImpl implements SgKstlService {
    @Autowired
    private SgKstlMapper sgKstlMapper;
}
