package com.litbo.hospital.user.service.impl;

import com.litbo.hospital.user.bean.User;
import com.litbo.hospital.user.dao.UserDao;
import com.litbo.hospital.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
