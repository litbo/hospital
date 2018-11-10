package com.litbo.hospital.user.service.impl;

import com.litbo.hospital.user.bean.Role;
import com.litbo.hospital.user.bean.User;
import com.litbo.hospital.user.dao.RoleDao;
import com.litbo.hospital.user.service.RoleService;
import com.litbo.hospital.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> getRoleByUsername(String username) {
        return roleDao.getRoleByUsername(username);
    }
}
