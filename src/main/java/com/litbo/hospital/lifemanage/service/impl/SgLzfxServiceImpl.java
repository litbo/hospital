package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgLzfxMapper;
import com.litbo.hospital.lifemanage.service.SgLzfxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SgLzfxServiceImpl implements SgLzfxService {
    @Autowired
    private SgLzfxMapper sgLzfxMapper;
}
