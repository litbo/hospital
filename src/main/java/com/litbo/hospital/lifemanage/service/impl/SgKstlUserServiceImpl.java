package com.litbo.hospital.lifemanage.service.impl;

import com.litbo.hospital.lifemanage.dao.SgKstlUserMapper;
import com.litbo.hospital.lifemanage.service.SgKstlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 科室讨论会议人员关联表Service实现类
 */
@Service
public class SgKstlUserServiceImpl implements SgKstlUserService {
    @Autowired
    private SgKstlUserMapper sgKstlUserMapper;
}
