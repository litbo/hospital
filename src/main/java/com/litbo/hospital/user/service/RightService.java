package com.litbo.hospital.user.service;

import com.litbo.hospital.user.bean.Right;
import com.litbo.hospital.user.bean.User;

import java.util.List;


public interface RightService {

    List<Right> getRightsByRolename(String roleName);
}
