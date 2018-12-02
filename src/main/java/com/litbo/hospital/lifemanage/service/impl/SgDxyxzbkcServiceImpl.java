package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgDxyxzbkcMapper;
import com.litbo.hospital.lifemanage.service.SgDxyxzbkcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 大型医学装备考察报告表Service实现类
 */
@Service
public class SgDxyxzbkcServiceImpl implements SgDxyxzbkcService {
    @Autowired
    private SgDxyxzbkcMapper SgDxyxzbkcMapper;
}
