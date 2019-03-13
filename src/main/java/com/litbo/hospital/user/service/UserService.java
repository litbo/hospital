package com.litbo.hospital.user.service;

import com.litbo.hospital.user.bean.SUser;
import com.litbo.hospital.user.vo.UserVo;


public interface UserService {

    SUser getUserByUsername(String username);

    Integer setUser(String userId);

    Integer updatePwd(String userId, String userPwd);

    UserVo getUserById(String userId);
}
