package com.litbo.hospital.user.service;

import com.litbo.hospital.user.bean.SUser;


public interface UserService {

    SUser getUserByUsername(String username);

    Integer setUser(String userId);

    Integer updatePwd(String userId, String userPwd);
}
