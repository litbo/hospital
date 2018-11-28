package com.litbo.hospital.user.service.impl;

import com.litbo.hospital.user.bean.Right;
import com.litbo.hospital.user.bean.User;
import com.litbo.hospital.user.dao.RightDao;
import com.litbo.hospital.user.service.RightService;
import com.litbo.hospital.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightServiceImpl implements RightService {

    @Autowired
    private RightDao rightDao;
    @Override
    public List<Right> getRightsByRolename(String roleName) {
        return rightDao.getRightsByRolename(roleName);
    }
}
