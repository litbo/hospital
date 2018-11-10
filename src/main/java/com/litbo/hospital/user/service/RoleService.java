package com.litbo.hospital.user.service;

import com.litbo.hospital.user.bean.Role;
import com.litbo.hospital.user.bean.User;

import java.util.List;


public interface RoleService {

    List<Role> getRoleByUsername(String username);
}
