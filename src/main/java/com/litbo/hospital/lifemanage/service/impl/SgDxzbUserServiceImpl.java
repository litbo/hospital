package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgDxzbUserMapper;
import com.litbo.hospital.lifemanage.service.SgDxzbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 大型医学装备考察报告考察人员表Service实现类
 */
@Service
public class SgDxzbUserServiceImpl implements SgDxzbUserService {
    @Autowired
    private SgDxzbUserMapper sgDxzbUserMapper;
}
